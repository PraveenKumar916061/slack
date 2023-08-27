package com.img.slack.service;

import com.img.slack.entities.WorkSpace;
import com.img.slack.repos.WorkSpaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class WorkSpaceServiceImp implements WorkSpaceService{

    @Autowired
    private WorkSpaceRepo workSpaceRepo;

    @Override
    public List<WorkSpace> listOfWorkSpaces() {
        return workSpaceRepo.findAll();
    }

    @Override
    public WorkSpace createWorkSpace(WorkSpace workSpace) {
        WorkSpace ws=new WorkSpace();
        ws.setWorkspace_name(workSpace.getWorkspace_name());
        ws.setDescription(workSpace.getDescription());
        ws.setCreated_by(workSpace.getCreated_by());
        workSpaceRepo.save(ws);
        return ws;
    }

    @Override
    public void deleteWorkSpace(int workSpace_id) {
        var v=workSpaceRepo.findById(workSpace_id);
        if(v.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No data found");
        workSpaceRepo.deleteById(workSpace_id);
    }

    @Override
    public WorkSpace updateWorkSpaceName(int workSpace_id, String workSpaceName) {
        var v=workSpaceRepo.findById(workSpace_id);
        if(v.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No data found");
        WorkSpace workSpace=v.get();
        workSpace.setWorkspace_name(workSpaceName);
        workSpaceRepo.save(workSpace);
        return workSpace;
    }

    @Override
    public List<WorkSpace> getWorkSpacesByUser(int user_id) {
        return workSpaceRepo.getWorkSpacesByUser(user_id);
    }
}
