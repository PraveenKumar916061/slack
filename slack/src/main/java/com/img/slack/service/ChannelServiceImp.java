package com.img.slack.service;

import com.img.slack.entities.Channel;
import com.img.slack.repos.ChannelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {

    @Autowired
    private ChannelRepo channelRepo;

    public List<Channel> getAllChannels(){
        return channelRepo.findAll();
    }


}
