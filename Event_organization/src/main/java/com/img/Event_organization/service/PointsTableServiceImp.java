package com.img.Event_organization.service;

import com.img.Event_organization.entity.Points_Table;
import com.img.Event_organization.repository.PointsTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PointsTableServiceImp implements PointsTableService{

    @Autowired
    private PointsTableRepository pointsTableRepository;
    @Override
    public Points_Table addPointsForTeam(Points_Table pTable) {
        Points_Table pt=new Points_Table();
        pt.setTeam_id(pTable.getTeam_id());
        pt.setReferee_id(pTable.getReferee_id());
        pt.setRound_1(pTable.getRound_1());
        pt.setRound_2(pTable.getRound_2());
        pt.setRound_3(pTable.getRound_3());
        double avg=(pTable.getRound_1()+pTable.getRound_2()+pTable.getRound_3())/3;
        pt.setAvg_points(avg);
        pointsTableRepository.save(pt);
        return pt;
    }

    @Override
    public List<Points_Table> getPointsTable() {
        return pointsTableRepository.findAll();
    }

    @Override
    public void deletePointsForTeam(int team_id) {
        Optional<Points_Table> pointsTable =pointsTableRepository.findById(team_id);
        if(pointsTable.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Inavalid team id or id not found");
        pointsTableRepository.deleteById(team_id);
    }

    @Override
    public Points_Table updatePoints(int team_id,Points_Table points_Table) {
        Optional<Points_Table> pointsTable =pointsTableRepository.findById(team_id);
        if(pointsTable.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Inavalid team id or id not found");

        Points_Table pt=pointsTable.get();
        pt.setRound_1(points_Table.getRound_1());
        pt.setRound_2(points_Table.getRound_2());
        pt.setRound_3(points_Table.getRound_3());
        double avg=(points_Table.getRound_1()+points_Table.getRound_2()+points_Table.getRound_3())/3;
        pt.setAvg_points(avg);
        pointsTableRepository.save(pt);
        return pt;
    }

    @Override
    public List<Points_Table> top_3_InPointsTable() {
        var pointsTables=pointsTableRepository.getTop3InPointsTable();
        List<Points_Table> pt=pointsTables.stream().limit(3).collect(Collectors.toList());
        return pt;
    }
}
