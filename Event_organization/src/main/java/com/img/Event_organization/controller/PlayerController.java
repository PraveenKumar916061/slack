package com.img.Event_organization.controller;

import com.img.Event_organization.entity.Player;
import com.img.Event_organization.exception.AlreadyTeamFilledException;
import com.img.Event_organization.exception.CollegeNotAllowedException;
import com.img.Event_organization.exception.InvalidEmailException;
import com.img.Event_organization.exception.InvalidMobileNumberException;
import com.img.Event_organization.service.PlayerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerServiceImp playerServiceImp;

    @PostMapping("/registerPlayer")
    public Player registerPlayer(@RequestBody Player player) throws InvalidMobileNumberException, InvalidEmailException, AlreadyTeamFilledException , CollegeNotAllowedException {
        return playerServiceImp.registerPlayer(player);
    }

    @DeleteMapping("/removePlayer/{player_id}")
    public String removePlayer(@PathVariable("player_id") int player_id) {
        playerServiceImp.removePlayer(player_id);
        return player_id+" Player successfully removed";
    }

    @PutMapping("/updatePlayerEmail/{player_id}")
    public Player updatePlayerEmail(@PathVariable("player_id") int player_id,@RequestParam("email") String email) throws InvalidEmailException{
        return playerServiceImp.updatePlayerEmail(player_id,email);
    }

    @GetMapping("/listOfTeamPlayers/{team_id}")
    public List<Player> teamPlayerList(@PathVariable("team_id") int team_id) {
        return playerServiceImp.teamPlayerList(team_id);
    }

    @PutMapping("/updatePlayerPhno/{player_id}")
    public Player updatePlayerPhNo(@PathVariable("player_id") int player_id,@RequestParam("phno") long phno) throws InvalidMobileNumberException {
        return  playerServiceImp.updatePlayerPhNo(player_id,phno);
    }
}
