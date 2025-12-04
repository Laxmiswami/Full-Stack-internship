# Full-Stack-internship
# Mini Team Chat Application

A simple real-time team chat platform where users can join channels and send messages.  
This mini project is built using **Java (Spring Boot)**, **MySQL**, **HTML**, **CSS**, and **JavaScript**.

---

## 📌 Project Overview

The Mini Team Chat Application allows users to:

- Register and log in
- Create and join chat channels
- Send and receive messages in real-time
- View chat history
- See online/offline status of users

This project is designed as a lightweight clone of team communication tools like Slack or Microsoft Teams.

---

## 🚀 Features

### 🔹 User Features
- User Signup & Login  
- JWT-based authentication  
- Online/offline status  
- Join / Leave channels  

### 🔹 Chat Features
- Real-time messaging with WebSocket  
- Channel-wise chat  
- Message history  
- Automatic timestamping  

### 🔹 Admin / Channel Features
- Create channels  
- Add users to channels  
- Member listing  

---

## 🛠️ Technologies Used

| Component | Technology |
|----------|------------|
| Backend | Java, Spring Boot |
| Frontend | HTML, CSS, JavaScript |
| Database | MySQL |
| Realtime | WebSocket (STOMP) |
| Build Tool | Maven |

---

## 📂 Project Structure

mini-team-chat/
│
├── backend/
│   ├── pom.xml
│   ├── mvnw
│   ├── mvnw.cmd
│   └── src/
│       ├── main/
│       │   ├── java/
│       │   │   └── com/
│       │   │       └── example/
│       │   │           └── chat/
│       │   │               ├── ChatApplication.java
│       │   │               │
│       │   │               ├── config/
│       │   │               │   └── WebSocketConfig.java
│       │   │               │
│       │   │               ├── controller/
│       │   │               │   ├── AuthController.java
│       │   │               │   ├── ChannelController.java
│       │   │               │   ├── ChatController.java
│       │   │               │   └── MessageRestController.java
│       │   │               │
│       │   │               ├── dto/
│       │   │               │   └── ChatMessageDTO.java
│       │   │               │
│       │   │               ├── model/
│       │   │               │   ├── User.java
│       │   │               │   ├── Channel.java
│       │   │               │   └── Message.java
│       │   │               │
│       │   │               └── repository/
│       │   │                   ├── UserRepository.java
│       │   │                   ├── ChannelRepository.java
│       │   │                   └── MessageRepository.java
│       │   │
│       │   └── resources/
│       │       ├── application.properties
│       │       └── static/   (optional for frontend files)
│       │
│       └── test/  (optional for unit tests)
│
└── frontend/
    ├── index.html          → Login Page
    ├── signup.html         → Signup Page
    ├── channels.html       → Channel List Page
    ├── chat.html           → Chat Page
    │
    ├── css/
    │   └── styles.css
    │
    └── js/
        ├── auth.js         → login/signup JS
        ├── channels.js     → load channels
        ├── chat.js         → WebSocket + messages
        └── api.js          → all backend REST calls
