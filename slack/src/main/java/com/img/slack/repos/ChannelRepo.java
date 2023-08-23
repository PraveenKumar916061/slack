package com.img.slack.repos;

import com.img.slack.entities.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepo extends JpaRepository<Channel,Integer> {
}
