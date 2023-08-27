package com.img.slack.service;

import com.img.slack.entities.Threadd;
import com.img.slack.repos.ThreadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThreadServiceImp implements ThreadService{

    @Autowired
    private ThreadRepo threadRepo;

    @Override
    public Threadd sendReplyForMessage(int msg_id, Threadd threadd) {
        var v=threadRepo.findAll();
        Threadd th=new Threadd();
        for(Threadd msg:v){
            if(msg.getMessage_id()==msg_id){
                th.setMessage_id(msg_id);
                th.setReply_id(threadd.getReply_id());
                threadRepo.save(th);
            }
        }
        return th;
    }

    @Override
    public void deleteThreadForMessage(int thread_id) {
        threadRepo.deleteById(thread_id);
    }
}
