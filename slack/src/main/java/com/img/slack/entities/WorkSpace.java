package com.img.slack.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="workspaces")
public class WorkSpace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int workspace_id;

    private String workspace_name;

    private String description;

    private int created_by;

    @ManyToMany
    @JoinTable(
            name = "workspace_access",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "workspace_id")
    )
    @JoinColumn(name="user_id",insertable = false,updatable = false)
    private List<User> users;

    @OneToMany(mappedBy = "workSpace")
    private List<WorkSpace_Access> workSpaceAccesses;

    public int getWorkspace_id() {
        return workspace_id;
    }

    public void setWorkspace_id(int workspace_id) {
        this.workspace_id = workspace_id;
    }

    public String getWorkspace_name() {
        return workspace_name;
    }

    public void setWorkspace_name(String workspace_name) {
        this.workspace_name = workspace_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<WorkSpace_Access> getWorkSpaceAccesses() {
        return workSpaceAccesses;
    }

    public void setWorkSpaceAccesses(List<WorkSpace_Access> workSpaceAccesses) {
        this.workSpaceAccesses = workSpaceAccesses;
    }
}
