package com.img.slack.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int message_id;

    private String content;

    private int channel_id;

    private LocalDateTime timestamp;

    private int channel_access_id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="channel_id",insertable = false,updatable = false)
    private Channel channell;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="channel_access_id",insertable = false,updatable = false)
    private Channel_Access channelAcces;

    @OneToMany(mappedBy = "message")
    @JsonIgnore
    private List<Threadd> threadds;

    @OneToMany(mappedBy = "messagee")
    @JsonIgnore
    private List<Threadd> threaddList;

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(int channel_id) {
        this.channel_id = channel_id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getChannel_access_id() {
        return channel_access_id;
    }

    public void setChannel_access_id(int channel_access_id) {
        this.channel_access_id = channel_access_id;
    }

    public Channel getChannell() {
        return channell;
    }

    public void setChannell(Channel channell) {
        this.channell = channell;
    }

    public Channel_Access getChannelAcces() {
        return channelAcces;
    }

    public void setChannelAcces(Channel_Access channelAcces) {
        this.channelAcces = channelAcces;
    }

    public List<Threadd> getThreadds() {
        return threadds;
    }

    public void setThreadds(List<Threadd> threadds) {
        this.threadds = threadds;
    }

    public List<Threadd> getThreaddList() {
        return threaddList;
    }

    public void setThreaddList(List<Threadd> threaddList) {
        this.threaddList = threaddList;
    }
}
