package com.example.chat.model;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name="channels")
public class Channel {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(unique=true, nullable=false)
  private String name;
  private boolean isPrivate = false;
  private Instant createdAt = Instant.now();
  // getters/setters
}

