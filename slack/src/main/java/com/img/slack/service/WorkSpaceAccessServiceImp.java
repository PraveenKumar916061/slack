package com.img.slack.service;

import com.img.slack.entities.WorkSpace_Access;
import com.img.slack.repos.WorkSpace_AccessRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class WorkSpaceAccessServiceImp implements WorkSpaceAccessService {

    @Autowired
    private WorkSpace_AccessRepo workSpaceAccessRepo;


    @Override
    public List<WorkSpace_Access> listOfWorkSpaceAccesses() {
        return workSpaceAccessRepo.findAll();
    }

    @Override
    public WorkSpace_Access createWorkspaceAccessForUSer(WorkSpace_Access wa) {
        WorkSpace_Access wsa=new WorkSpace_Access();
        wsa.setWorkspace_id(wa.getWorkspace_id());
        wsa.setWorkspace_user_id(wsa.getWorkspace_user_id());
        workSpaceAccessRepo.save(wsa);
        return wsa;
    }

    @Override
    public void removeWorkspaceAccessForUser(int wsa_id) {
        var v=workSpaceAccessRepo.findById(wsa_id);
        if(v.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid workspace id");
        workSpaceAccessRepo.deleteById(wsa_id);
    }
}
