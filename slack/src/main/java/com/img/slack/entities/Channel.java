package com.img.slack.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="channels")
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int channel_id;

    private String channel_name;

    private String description;

    private int workspace_access_id;

    @OneToMany(mappedBy = "channel")
    private List<WorkSpace_Access> workSpaceAccesses;

    @OneToMany(mappedBy = "channel")
    private List<Channel_Access> channelAccesses;

    @OneToMany(mappedBy = "channel")
    private List<Message> messages;

    public int getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(int channel_id) {
        this.channel_id = channel_id;
    }

    public String getChannel_name() {
        return channel_name;
    }

    public void setChannel_name(String channel_name) {
        this.channel_name = channel_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWorkspace_access_id() {
        return workspace_access_id;
    }

    public void setWorkspace_access_id(int workspace_access_id) {
        this.workspace_access_id = workspace_access_id;
    }

    public List<WorkSpace_Access> getWorkSpaceAccesses() {
        return workSpaceAccesses;
    }

    public void setWorkSpaceAccesses(List<WorkSpace_Access> workSpaceAccesses) {
        this.workSpaceAccesses = workSpaceAccesses;
    }

    public List<Channel_Access> getChannelAccesses() {
        return channelAccesses;
    }

    public void setChannelAccesses(List<Channel_Access> channelAccesses) {
        this.channelAccesses = channelAccesses;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
