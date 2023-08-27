package com.img.Event_organization.controller;

import com.img.Event_organization.entity.Points_Table;
import com.img.Event_organization.repository.PointsTableRepository;
import com.img.Event_organization.service.PointsTableServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class PointsTableController {

    @Autowired
    private PointsTableServiceImp pointsTableServiceImp;

    @PostMapping("/addPoints")
    public Points_Table addPointsForTeam(@RequestBody Points_Table pTable) {
        return pointsTableServiceImp.addPointsForTeam(pTable);
    }

    @GetMapping("/getPointsTable")
    public List<Points_Table> getPointsTable() {
        return pointsTableServiceImp.getPointsTable();
    }

    @DeleteMapping("/deletePoints/{team_id}")
    public String deletePointsForTeam(@PathVariable("team_id") int team_id) {
        pointsTableServiceImp.deletePointsForTeam(team_id);
        return team_id+" deleted int points table";
    }

    @PutMapping("/updatePoints/{team_id}")
    public Points_Table updatePoints(@PathVariable("team_id") int team_id,@RequestBody Points_Table points_Table) {
        return pointsTableServiceImp.updatePoints(team_id,points_Table);
    }

    @GetMapping("/top3InPointsTable")
    public List<Points_Table> getTop3InPointsTable(){
        return pointsTableServiceImp.top_3_InPointsTable();
    }
}
