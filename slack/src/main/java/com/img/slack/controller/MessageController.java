package com.img.slack.controller;

import com.img.slack.entities.Message;
import com.img.slack.repos.MessageRepo;
import com.img.slack.service.MessageServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageServiceImp messageServiceImp;

    @PostMapping("/sendMessage")
    public Message sendMessage(Message message) {
        return messageServiceImp.sendMessage(message);
    }

    @PutMapping("/editMessage/{msg_id}")
    public Message editMessage(@PathVariable("msg_id") int msg_id,@RequestParam("content") String content) {
        return messageServiceImp.editMessage(msg_id,content);
    }

    @GetMapping("/getMsgByChannel/{channel_id}")
    public List<Message> getMsgByChannel(@PathVariable("channel_id") int channel_id) {
        return messageServiceImp.getMsgByChannel(channel_id);
    }

    @DeleteMapping("/deleteMessage/{msg_id}")
    public String deleteMessage(@PathVariable("msg_id") int msg_id) {
        messageServiceImp.deleteMessage(msg_id);
        return msg_id+" message deleted";
    }
}
