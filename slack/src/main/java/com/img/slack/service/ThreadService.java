package com.img.slack.service;

import com.img.slack.entities.Threadd;

public interface ThreadService {

    Threadd sendReplyForMessage(int msg_id, Threadd threadd);

    void deleteThreadForMessage(int thread_id);
}
