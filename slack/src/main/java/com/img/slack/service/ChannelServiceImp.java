package com.img.slack.service;

import com.img.slack.entities.Channel;
import com.img.slack.entities.User;
import com.img.slack.repos.ChannelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ChannelServiceImp implements ChannelService{

    @Autowired
    private ChannelRepo channelRepo;

    public List<Channel> getChannels(){
        return channelRepo.findAll();
    }

    @Override
    public Channel createChannel(Channel ch) {
        Channel channel=new Channel();
        channel.setChannel_name(ch.getChannel_name());
        channel.setDescription(ch.getDescription());
        channel.setWorkspace_access_id(ch.getWorkspace_access_id());

        channelRepo.save(channel);
        return channel;
    }

    @Override
    public void deleteChannel(int channel_id) {
        channelRepo.deleteById(channel_id);
    }

    @Override
    public List<Channel> listOfChannelsByWorkSpace(Integer wpa_id) {
        List<Channel> list= channelRepo.listOfChannelsByWorkSpaceAccess_id(wpa_id);
        return list;
    }

    @Override
    public Channel updateChannelName(int channel_id, String channel_name) {
        var v=channelRepo.findById(channel_id);
        if(v.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No data found");
        Channel channel=v.get();
        channel.setChannel_name(channel_name);
        channelRepo.save(channel);
        return channel;
    }


}
