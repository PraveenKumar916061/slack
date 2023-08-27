package com.img.slack.repos;

import com.img.slack.entities.WorkSpace_Access;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkSpace_AccessRepo extends JpaRepository<WorkSpace_Access,Integer> {

}
