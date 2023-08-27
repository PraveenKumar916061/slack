package com.img.slack.controller;

import com.img.slack.entities.Channel;
import com.img.slack.service.ChannelServiceImp;
import org.apache.commons.collections4.Put;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ChannelController {

    @Autowired
    private ChannelServiceImp channelServiceImp;

    @GetMapping("/getchannels")
    public List<Channel> getChannels(){
        return channelServiceImp.getChannels();
    }

    @PostMapping("/createChannel")
    public Channel createChannel(@RequestBody Channel channel){
        return channelServiceImp.createChannel(channel);
    }

    @DeleteMapping("/deletechannel/{channel_id}")
    public String deleteChannel(@PathVariable("channel_id") int channel_id) {
        channelServiceImp.deleteChannel(channel_id);
        return "Channel id "+channel_id+" successfully deleted";
    }

    @GetMapping("/listOfChannelByWPA/{wpa_id}")
    public List<Channel> listOfChannelsByWorkSpace(@PathVariable("wpa_id") Integer wpa_id) {
        return channelServiceImp.listOfChannelsByWorkSpace(wpa_id);
    }

    @PutMapping("/updateChannelname/{channel_id}")
    public Channel updateChannelName(@PathVariable("channel_id") int channel_id,@RequestParam("channel_name") String channel_name) {
        return channelServiceImp.updateChannelName(channel_id,channel_name);
    }
}
