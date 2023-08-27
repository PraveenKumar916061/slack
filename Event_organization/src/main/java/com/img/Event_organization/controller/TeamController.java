package com.img.Event_organization.controller;

import com.img.Event_organization.entity.Team;
import com.img.Event_organization.service.TeamServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class TeamController {

    @Autowired
    private TeamServiceImp teamServiceImp;

    @PostMapping("/teamregister")
    public Team teamRegister(@RequestBody Team team) {
       return teamServiceImp.teamRegister(team);
    }

    @GetMapping("/getTeams")
    public List<Team> listOfTeams() {
        return teamServiceImp.listOfTeams();
    }

    @DeleteMapping("/removeteam/{teamid}")
    public String removeTeam(@PathVariable("teamid") int team_id) {
        teamServiceImp.removeTeam(team_id);
        return team_id+" data deleted";
    }

    @PutMapping("/updateEvent/{team_id}")
    public Team updateEventForTeam(@PathVariable("team_id") int team_id,@RequestParam("event_id") int event_id) {
        return teamServiceImp.updateEventForTeam(team_id,event_id);
    }
}
