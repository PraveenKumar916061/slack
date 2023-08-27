package com.img.slack.controller;

import com.img.slack.entities.Channel_Access;
import com.img.slack.entities.Message;
import com.img.slack.entities.User;
import com.img.slack.repos.ChannelRepo;
import com.img.slack.repos.Channel_AccessRepo;
import com.img.slack.repos.MessageRepo;
import com.img.slack.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class TestingController {

    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private ChannelService channelService;

    @Autowired
    private Channel_AccessRepo chAcRepo;

    @GetMapping("/hello")
    @ResponseBody
    public String test(){
        return "Hello Slack";
    }

    @GetMapping("/getmsg")
    @ResponseBody
    public List<Message> getMessages(){
        return messageRepo.getAllMessages();
    }

    @GetMapping("/getUser/id")
    @ResponseBody
    public List<User> getAllUsers(@PathVariable("id") int id){
        return chAcRepo.getUsers(id);
    }
}
