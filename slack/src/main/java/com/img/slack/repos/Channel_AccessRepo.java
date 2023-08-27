package com.img.slack.repos;

import com.img.slack.entities.Channel_Access;
import com.img.slack.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Channel_AccessRepo extends JpaRepository<Channel_Access,Integer> {

}
