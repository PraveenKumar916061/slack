package com.img.slack.repos;

import com.img.slack.entities.Channel_Access;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Channel_AccessRepo extends JpaRepository<Channel_Access,Integer> {
}
