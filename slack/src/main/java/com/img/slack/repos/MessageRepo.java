package com.img.slack.repos;

import com.img.slack.entities.Message;
import com.img.slack.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message,Integer> {

    @Query("from Message m where m.channel_id=:channel_id")
    List<Message> getMessagesByChannel(@Param("channel_id") int channel_id);
}
