package com.img.slack.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    @JoinColumn(name="user_id",referencedColumnName = "workspace_access_id",insertable = false,updatable = false)
    private WorkSpace_Access workSpace_access;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="channel_id",insertable = false,updatable = false)
    private Channel channel;

    @OneToMany(mappedBy = "channelAcces")
    @JsonIgnore
    private List<Message> messagess;

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

    public WorkSpace_Access getWorkSpace_access() {
        return workSpace_access;
    }

    public void setWorkSpace_access(WorkSpace_Access workSpace_access) {
        this.workSpace_access = workSpace_access;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public List<Message> getMessagess() {
        return messagess;
    }

    public void setMessagess(List<Message> messagess) {
        this.messagess = messagess;
    }
}
