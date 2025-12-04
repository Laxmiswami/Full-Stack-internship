package com.example.chat.controller;

import com.example.chat.dto.ChatMessageDTO;
import com.example.chat.model.Message;
import com.example.chat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.time.Instant;

@Controller
public class ChatController {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat.sendMessage")
    public void sendMessage(ChatMessageDTO messageDTO) {

        // 1. Save message into DB
        Message message = new Message();
        message.setChannelId(messageDTO.getChannelId());
        message.setSenderId(messageDTO.getSenderId());
        message.setText(messageDTO.getText());
        message.setCreatedAt(Instant.now());
        messageRepository.save(message);

        // 2. Broadcast to all subscribers of this channel
        messagingTemplate.convertAndSend(
                "/topic/channel." + messageDTO.getChannelId(),
                messageDTO
        );
    }
}
