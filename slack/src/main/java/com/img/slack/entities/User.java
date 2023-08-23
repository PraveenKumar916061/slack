package com.img.slack.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String user_name;
    private String password;

    @ManyToMany(mappedBy = "users")
    private List<WorkSpace> workSpaces;

    @ManyToOne
    @JoinColumn(name="user_id",insertable = false,updatable = false)
    private WorkSpace_Access workSpaceAccess;

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setWorkSpaces(List<WorkSpace> workSpaces) {
        this.workSpaces = workSpaces;
    }

    public void setWorkSpaceAccess(WorkSpace_Access workSpaceAccess) {
        this.workSpaceAccess = workSpaceAccess;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public List<WorkSpace> getWorkSpaces() {
        return workSpaces;
    }

    public WorkSpace_Access getWorkSpaceAccess() {
        return workSpaceAccess;
    }
}
