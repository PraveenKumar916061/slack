package com.img.slack.controller;

import com.img.slack.entities.WorkSpace_Access;
import com.img.slack.service.WorkSpaceAccessServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class WorkSpaceAccessController {

    @Autowired
    private WorkSpaceAccessServiceImp workSpaceAccessServiceImp;

    @GetMapping("/listOfWorkspaceAccess")
    public List<WorkSpace_Access> listOfWorkSpaceAccesses() {
        return workSpaceAccessServiceImp.listOfWorkSpaceAccesses();
    }

    @PostMapping("/createWorkspaceAccessForUSer")
    public WorkSpace_Access createWorkspaceAccessForUSer(@RequestBody WorkSpace_Access wa) {
        return workSpaceAccessServiceImp.createWorkspaceAccessForUSer(wa);
    }

    @DeleteMapping("/removeWorkspaceAccessForUser/{wsa_id}")
    public String removeWorkspaceAccessForUser(@PathVariable("wsa_id") int wsa_id) {
         workSpaceAccessServiceImp.removeWorkspaceAccessForUser(wsa_id);
        return "Access remove for user";
    }
}
