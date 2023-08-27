package com.img.slack.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<WorkSpace> workSpaces;

    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    private List<WorkSpace_Access> workSpaceAccessess;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<WorkSpace> getWorkSpaces() {
        return workSpaces;
    }

    public void setWorkSpaces(List<WorkSpace> workSpaces) {
        this.workSpaces = workSpaces;
    }

    public List<WorkSpace_Access> getWorkSpaceAccessess() {
        return workSpaceAccessess;
    }

    public void setWorkSpaceAccessess(List<WorkSpace_Access> workSpaceAccessess) {
        this.workSpaceAccessess = workSpaceAccessess;
    }
}
