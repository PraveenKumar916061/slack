package com.img.slack.service;

import com.img.slack.entities.WorkSpace_Access;

import java.util.List;

public interface WorkSpaceAccessService {

    List<WorkSpace_Access> listOfWorkSpaceAccesses();

    WorkSpace_Access createWorkspaceAccessForUSer(WorkSpace_Access workSpaceAccess);

    void removeWorkspaceAccessForUser(int wsa_id);
}
