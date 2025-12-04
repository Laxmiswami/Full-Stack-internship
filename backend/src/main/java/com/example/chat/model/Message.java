package com.example.chat.model;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name="messages", indexes = @Index(name = "idx_channel_created_at", columnList = "channel_id, createdAt"))
public class Message {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name="channel_id", nullable=false)
  private Long channelId;
  @Column(name="sender_id", nullable=false)
  private Long senderId;
  @Column(columnDefinition = "TEXT")
  private String text;
  private Instant createdAt = Instant.now();
  // getters/setters
}

