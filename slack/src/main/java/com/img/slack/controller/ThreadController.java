package com.img.slack.controller;


import com.img.slack.entities.Threadd;
import com.img.slack.service.ThreadServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ThreadController {

    @Autowired
    private ThreadServiceImp threadServiceImp;

    @PostMapping("/sendReplyForMessage/{msg_id}")
    public Threadd sendReplyForMessage(@PathVariable("msg_id") int msg_id,@RequestBody Threadd threadd) {
        return threadServiceImp.sendReplyForMessage(msg_id,threadd);
    }

    @DeleteMapping("/deleteThreadForMessage/{thread_id}")
    public String deleteThreadForMessage(@PathVariable("thread_id") int thread_id) {
        threadServiceImp.deleteThreadForMessage(thread_id);
        return thread_id+" message deleted";
    }
}
