package com.example.chat.repository;

import com.example.chat.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;

import java.time.Instant;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("SELECT m FROM Message m WHERE m.channelId = :channelId AND m.createdAt < :before ORDER BY m.createdAt DESC")
    List<Message> findPage(Long channelId, Instant before, Pageable pageable);
}

