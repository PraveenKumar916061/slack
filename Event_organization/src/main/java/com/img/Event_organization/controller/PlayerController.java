package com.img.Event_organization.controller;

import com.img.Event_organization.entity.Player;
import com.img.Event_organization.exception.AlreadyTeamFilledException;
import com.img.Event_organization.exception.InvalidEmailException;
import com.img.Event_organization.exception.InvalidMobieleNumberException;
import com.img.Event_organization.service.PlayerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class PlayerController {

    @Autowired
    private PlayerServiceImp playerServiceImp;

    @PostMapping("/registerPlayer")
    public Player registerPlayer(@RequestBody Player player) throws InvalidMobieleNumberException, InvalidEmailException, AlreadyTeamFilledException {
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
    public Player updatePlayerPhNo(@PathVariable("player_id") int player_id,@RequestParam("phno") long phno) throws InvalidMobieleNumberException {
        return  playerServiceImp.updatePlayerPhNo(player_id,phno);
    }
}
