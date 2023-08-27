package com.img.slack.controller;

import com.img.slack.entities.Channel_Access;
import com.img.slack.repos.Channel_AccessRepo;
import com.img.slack.service.ChannelAccessServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ChannelAccessController {
    @Autowired
    private ChannelAccessServiceImp channelAccessServiceImp;

    @PostMapping("/createChannelAccess")
    public Channel_Access createChannelAccess(@RequestBody Channel_Access channelAccess) {
        return channelAccessServiceImp.createChannelAccess(channelAccess);
    }

    @DeleteMapping("/removeChannelAccess/{channel_id}")
    public String removeChannelAccess(@PathVariable("channel_id") int channel_id) {
        channelAccessServiceImp.removeChannelAccess(channel_id);
        return "Channel Access Removed for "+channel_id;
    }
}

