package com.example.chat.model;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name="users")
public class User {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @Column(unique=true, nullable=false)
  private String email;
  @Column(name="password_hash", nullable=false)
  private String passwordHash;
  private String avatarUrl;
  private Instant createdAt = Instant.now();
  // getters/setters
}

