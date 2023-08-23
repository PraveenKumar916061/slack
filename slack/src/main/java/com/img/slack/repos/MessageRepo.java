package com.img.slack.repos;

import com.img.slack.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message,Integer> {
}
