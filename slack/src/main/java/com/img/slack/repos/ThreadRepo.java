package com.img.slack.repos;

import com.img.slack.entities.Threadd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThreadRepo extends JpaRepository<Threadd,Integer> {
}
