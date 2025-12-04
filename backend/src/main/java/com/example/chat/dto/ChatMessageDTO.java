package com.example.chat.dto;

public class ChatMessageDTO {

    private Long channelId;
    private Long senderId;
    private String text;

    public ChatMessageDTO() {}

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}
