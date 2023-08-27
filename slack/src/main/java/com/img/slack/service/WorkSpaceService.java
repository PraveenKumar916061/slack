package com.img.slack.service;

import com.img.slack.entities.WorkSpace;

import java.util.List;

public interface WorkSpaceService {

    List<WorkSpace> listOfWorkSpaces();

    WorkSpace createWorkSpace(WorkSpace workSpace);

    void deleteWorkSpace(int workSpace_id);

    WorkSpace updateWorkSpaceName(int workSpace_id,String workSpaceName);

    List<WorkSpace> getWorkSpacesByUser(int user_id);
}
