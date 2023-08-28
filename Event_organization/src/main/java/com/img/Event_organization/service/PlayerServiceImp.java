package com.img.Event_organization.service;

import com.img.Event_organization.entity.Player;
import com.img.Event_organization.exception.AlreadyTeamFilledException;
import com.img.Event_organization.exception.CollegeNotAllowedException;
import com.img.Event_organization.exception.InvalidEmailException;
import com.img.Event_organization.exception.InvalidMobileNumberException;
import com.img.Event_organization.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PlayerServiceImp implements PlayerService{

    @Autowired
    private PlayerRepository playerRepository;


    Pattern p1=Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9_.]*@gmail.com");
    Pattern p2=Pattern.compile("(0|91)?[6-9][0-9]{9}");

    public Player registerPlayer(Player player) throws InvalidMobileNumberException, InvalidEmailException, AlreadyTeamFilledException , CollegeNotAllowedException {
        int count=0;
        String collegename=null;
        List<Player> pl=playerRepository.findAll();
        for(var v: pl){
            if(v.getTeam_id()==player.getTeam_id()) {
                count++;
                collegename = v.getCollege_name();
            }
        }
        if(count<5) {
            Player p = new Player();
            p.setPlayer_name(player.getPlayer_name());
            p.setAge(player.getAge());
            if(count==0)
                p.setCollege_name(player.getCollege_name());
            else {
                if (player.getCollege_name().equalsIgnoreCase(collegename))
                    p.setCollege_name(player.getCollege_name());
                else
                    throw new CollegeNotAllowedException();
            }
            String s = String.valueOf(player.getPhone_no());
            Matcher matcher2 = p2.matcher(s);
            if (matcher2.matches())
                p.setPhone_no(player.getPhone_no());
            else
                throw new InvalidMobileNumberException();
            String s2 = player.getEmail();
            Matcher matcher1 = p1.matcher(s2);
            if (matcher1.matches())
                p.setEmail(player.getEmail());
            else
                throw new InvalidEmailException();
            p.setTeam_id(player.getTeam_id());
            playerRepository.save(p);
            return p;
        }
        else
            throw new AlreadyTeamFilledException();
    }

    @Override
    public void removePlayer(int player_id) {
        Optional<Player> p=playerRepository.findById(player_id);
        if(p.isPresent())
             playerRepository.deleteById(player_id);
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid Player Id");
    }

    @Override
    public Player updatePlayerEmail(int player_id,String email) throws InvalidEmailException{
        Optional<Player> player=playerRepository.findById(player_id);
        if(player.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Data Not found");
        Player p=player.get();
        Matcher matcher=p1.matcher(email);
        if(matcher.matches())
            p.setEmail(email);
        else
            throw new InvalidEmailException();
        playerRepository.save(p);
        return p;
    }

    @Override
    public List<Player> teamPlayerList(int team_id) {
        return playerRepository.teamPlayerList(team_id);
    }

    @Override
    public Player updatePlayerPhNo(int player_id, long phno) throws InvalidMobileNumberException {
        var v=playerRepository.findById(player_id);
        if(v.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Data Not found");
        Player p=v.get();
        String s=String.valueOf(phno);
        Matcher matcher=p2.matcher(s);
        if(matcher.matches())
            p.setPhone_no(phno);
        else
            throw new InvalidMobileNumberException();
        playerRepository.save(p);
        return p;
    }
}
