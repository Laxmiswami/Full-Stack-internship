package com.example.chat.controller;

import com.example.chat.model.Message;
import com.example.chat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = "*")
public class MessageRestController {

    @Autowired
    private MessageRepository messageRepository;

    // Load messages for a channel with pagination
    @GetMapping("/{channelId}")
    public List<Message> getMessages(
            @PathVariable Long channelId,
            @RequestParam(defaultValue = "50") int limit,
            @RequestParam(required = false) String before
    ) {
        // If no timestamp provided, load most recent
        Instant beforeTime = (before == null)
                ? Instant.now()
                : Instant.parse(before);

        return messageRepository.findPage(
                channelId,
                beforeTime,
                PageRequest.of(0, limit)
        );
    }
}
