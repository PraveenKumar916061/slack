package com.img.slack.repos;

import com.img.slack.entities.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChannelRepo extends JpaRepository<Channel,Integer> {

    @Query("from Channel c where c.workspace_access_id=:wap_id")
    List<Channel> listOfChannelsByWorkSpaceAccess_id(@Param("wap_id") int wap_id);
}
