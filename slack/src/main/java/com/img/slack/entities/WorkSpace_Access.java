package com.img.slack.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="workspace_access")
public class WorkSpace_Access {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int workspace_access_id;

    private int workspace_id;

    private int workspace_user_id;

    @ManyToOne
    @JoinColumn(name="workspace_id",insertable = false,updatable = false)
    private WorkSpace workSpace;

    @OneToMany(mappedBy = "workSpaceAccess")
    private List<User> users;

    @ManyToOne
    @JoinColumn(name="workspace_access_id",insertable = false,updatable = false)
    private Channel channel;

    public int getWorkspace_access_id() {
        return workspace_access_id;
    }

    public void setWorkspace_access_id(int workspace_access_id) {
        this.workspace_access_id = workspace_access_id;
    }

    public int getWorkspace_id() {
        return workspace_id;
    }

    public void setWorkspace_id(int workspace_id) {
        this.workspace_id = workspace_id;
    }

    public int getWorkspace_user_id() {
        return workspace_user_id;
    }

    public void setWorkspace_user_id(int workspace_user_id) {
        this.workspace_user_id = workspace_user_id;
    }

    public WorkSpace getWorkSpace() {
        return workSpace;
    }

    public void setWorkSpace(WorkSpace workSpace) {
        this.workSpace = workSpace;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
