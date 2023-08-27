package com.img.slack.controller;

import com.img.slack.entities.WorkSpace;
import com.img.slack.repos.WorkSpaceRepo;
import com.img.slack.service.WorkSpaceServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class WorkSpaceController {

    @Autowired
    private WorkSpaceServiceImp workSpaceServiceImp;

    @GetMapping("/listOfWorkspace")
    public List<WorkSpace> listOfWorkSpaces() {
        return workSpaceServiceImp.listOfWorkSpaces();
    }

    @PostMapping("/createWorkspace")
    public WorkSpace createWorkSpace(@RequestBody WorkSpace workSpace) {
        return workSpaceServiceImp.createWorkSpace(workSpace);
    }

    @DeleteMapping("/deleteWorkspace/{workSpace_id}")
    public String deleteWorkSpace(@PathVariable("workSpace_id") int workSpace_id) {
        workSpaceServiceImp.deleteWorkSpace(workSpace_id);
        return workSpace_id+" workspace deleted";
    }

    @PutMapping("/updateWorkspaceName/{workSpace_id}")
    public WorkSpace updateWorkSpaceName(@PathVariable("workSpace_id") int workSpace_id,@RequestParam("workSpaceName") String workSpaceName) {
        return workSpaceServiceImp.updateWorkSpaceName(workSpace_id,workSpaceName);
    }

    @GetMapping("/getWorkspacesByUser/{user_id}")
    public List<WorkSpace> getWorkSpacesByUser(@PathVariable("user_id") int user_id) {
        return workSpaceServiceImp.getWorkSpacesByUser(user_id);
    }
}
