package com.img.slack.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="channel_access")
public class Channel_Access {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int channel_access_id;

    private int channel_id;

    private int user_id;

    @ManyToOne
    @JoinColumn(name="channel_id",insertable = false,updatable = false)
    private Channel channel;

    @ManyToOne
    @JoinColumn(name = "channel_id",insertable = false,updatable = false)
    private WorkSpace_Access workSpaceAccess;

    @OneToMany(mappedBy = "channelAcces")
    private List<Message> messages;

    public int getChannel_access_id() {
        return channel_access_id;
    }

    public void setChannel_access_id(int channel_access_id) {
        this.channel_access_id = channel_access_id;
    }

    public int getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(int channel_id) {
        this.channel_id = channel_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public WorkSpace_Access getWorkSpaceAccess() {
        return workSpaceAccess;
    }

    public void setWorkSpaceAccess(WorkSpace_Access workSpaceAccess) {
        this.workSpaceAccess = workSpaceAccess;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
