package com.img.slack.entities;

import jakarta.persistence.*;

@Entity
@Table(name="threadd")
public class Threadd {
    @Id
    private int thread_id;

    private int message_id;

    private int reply_id;

    @ManyToOne
    @JoinColumn(name="message_id",insertable = false,updatable = false)
    private Message message;

    @ManyToOne
    @JoinColumn(name = "reply_id",insertable = false,updatable = false)
    private Message messagee;

    public int getThread_id() {
        return thread_id;
    }

    public void setThread_id(int thread_id) {
        this.thread_id = thread_id;
    }

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public int getReply_id() {
        return reply_id;
    }

    public void setReply_id(int reply_id) {
        this.reply_id = reply_id;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Message getMessagee() {
        return messagee;
    }

    public void setMessagee(Message messagee) {
        this.messagee = messagee;
    }
}
