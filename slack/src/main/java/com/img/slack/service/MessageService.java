package com.img.slack.service;

import com.img.slack.entities.Message;

import java.util.List;

public interface MessageService {

    Message sendMessage(Message message);

    Message editMessage(int msg_id,String content);

    List<Message> getMsgByChannel(int channel_id);

    void deleteMessage(int msg_id);


}
