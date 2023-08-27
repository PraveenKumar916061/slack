package com.img.slack.service;

import com.img.slack.entities.Message;
import com.img.slack.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImp implements MessageService{

    @Autowired
    private MessageRepo messageRepo;

    @Override
    public Message sendMessage(Message message) {
        Message message1=new Message();
        message1.setContent(message.getContent());
        message1.setChannel_id(message.getChannel_id());
        message1.setTimestamp(message.getTimestamp());
        message1.setChannel_access_id(message.getChannel_access_id());
        messageRepo.save(message1);
        return message1;
    }

    @Override
    public Message editMessage(int msg_id, String content) {
        var v=messageRepo.findById(msg_id);
        Message message=v.get();
        message.setContent(content);
        messageRepo.save(message);
        return message;
    }

    @Override
    public List<Message> getMsgByChannel(int channel_id) {
        return messageRepo.getMessagesByChannel(channel_id);
    }

    @Override
    public void deleteMessage(int msg_id) {
        messageRepo.deleteById(msg_id);
    }
}
