package com.img.slack.service;

import com.img.slack.entities.Channel_Access;
import com.img.slack.repos.Channel_AccessRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ChannelAccessServiceImp implements ChannelAccessService{

    @Autowired
    private Channel_AccessRepo channelAccessRepo;
    @Override
    public Channel_Access createChannelAccess(Channel_Access channelAccess) {
        Channel_Access cha=new Channel_Access();
        cha.setChannel_id(channelAccess.getChannel_id());
        cha.setUser_id(channelAccess.getUser_id());
        channelAccessRepo.save(cha);
        return cha;
    }

    @Override
    public void removeChannelAccess(int channel_id) {
        var v=channelAccessRepo.findById(channel_id);
        if(v.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid channel id");
        channelAccessRepo.deleteById(channel_id);
    }
}
