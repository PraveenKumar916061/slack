package com.img.slack.repos;

import com.img.slack.entities.WorkSpace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkSpaceRepo extends JpaRepository<WorkSpace,Integer> {

    @Query("from WorkSpace ws where created_by=:user_id")
    List<WorkSpace> getWorkSpacesByUser(@Param("user_id") int user_id);
}
