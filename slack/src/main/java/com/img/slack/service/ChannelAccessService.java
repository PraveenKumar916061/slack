package com.img.slack.service;

import com.img.slack.entities.Channel_Access;

public interface ChannelAccessService {

    Channel_Access createChannelAccess(Channel_Access channelAccess);

    void removeChannelAccess(int channel_id);
}
