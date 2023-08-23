package com.img.slack.repos;

import com.img.slack.entities.WorkSpace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkSpaceRepo extends JpaRepository<WorkSpace,Integer> {
}
