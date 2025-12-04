package com.example.chat.controller;

import com.example.chat.model.Channel;
import com.example.chat.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/channels")
@CrossOrigin(origins = "*")
public class ChannelController {

    @Autowired
    private ChannelRepository channelRepository;

    // 1. Create channel
    @PostMapping
    public Channel createChannel(@RequestBody Channel channel) {
        return channelRepository.save(channel);
    }

    // 2. Get all channels
    @GetMapping
    public List<Channel> getAllChannels() {
        return channelRepository.findAll();
    }

    // 3. Get channel by ID
    @GetMapping("/{id}")
    public Channel getChannel(@PathVariable Long id) {
        return channelRepository.findById(id).orElse(null);
    }
}
