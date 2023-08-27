package com.img.slack.service;

import com.img.slack.entities.Channel;
import com.img.slack.entities.User;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface ChannelService {

    List<Channel> getChannels();

    Channel createChannel(Channel ch);

    void deleteChannel(int channel_id);

    List<Channel> listOfChannelsByWorkSpace(Integer wpa_id);

    Channel updateChannelName(int channel_id,String channel_name);
}
