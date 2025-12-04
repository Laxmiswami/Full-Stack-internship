let stompClient = null;
let token = null;
let currentChannelId = 1; // default

document.getElementById('btnLogin').addEventListener('click', async ()=>{
  const email = document.getElementById('email').value;
  const password = document.getElementById('password').value;
  const res = await fetch('http://localhost:8080/api/auth/login', {
    method:'POST',
    headers: {'Content-Type':'application/json'},
    body: JSON.stringify({email,password})
  });
  if (!res.ok) return alert('Login failed');
  const data = await res.json();
  token = data.token;
  document.getElementById('login').style.display='none';
  document.getElementById('chat').style.display='block';
  connectSocket();
  loadChannels();
  loadMessages(currentChannelId);
});

function connectSocket() {
  const socket = new SockJS('http://localhost:8080/ws');
  stompClient = Stomp.over(socket);
  stompClient.connect({'Authorization': 'Bearer ' + token}, function(frame) {
    console.log('Connected:', frame);
    stompClient.subscribe('/topic/channel.' + currentChannelId, function(msg){
      const m = JSON.parse(msg.body);
      appendMessage(m);
    });
    stompClient.subscribe('/topic/presence', function(msg){ console.log('presence', msg.body); });
  });
}

async function loadMessages(channelId, before) {
  const url = `http://localhost:8080/api/messages/${channelId}?limit=20` + (before ? `&before=${encodeURIComponent(before)}` : '');
  const res = await fetch(url, {
    headers: { 'Authorization': 'Bearer ' + token }
  });
  const messages = await res.json();
  // messages returned newest-first, reverse to show oldest-first
  messages.reverse().forEach(appendMessage);
}

function appendMessage(m) {
  const el = document.createElement('div');
  el.textContent = `${m.senderId}: ${m.text} (${new Date(m.createdAt).toLocaleTimeString()})`;
  document.getElementById('messages').appendChild(el);
}

document.getElementById('sendBtn').addEventListener('click', ()=>{
  const text = document.getElementById('messageInput').value;
  if (!text || !stompClient) return;
  const payload = { channelId: currentChannelId, senderId: /* parse id from token or user object */ 1, text};
  stompClient.send('/app/chat.sendMessage', {}, JSON.stringify(payload));
  document.getElementById('messageInput').value='';
});

