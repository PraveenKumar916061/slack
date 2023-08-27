package com.img.Event_organization.controller;

import com.img.Event_organization.entity.Referee;
import com.img.Event_organization.service.RefereeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class RefereeController {

    @Autowired
    private RefereeServiceImp refereeServiceImp;

    @PostMapping("/addreferee")
    public Referee addReferee(@RequestBody Referee referee) {
        return refereeServiceImp.addReferee(referee);
    }

    @GetMapping("/listOfReferees")
    public List<Referee> listOfReferees() {
        return refereeServiceImp.listOfReferees();
    }

    @DeleteMapping("/removeReferee/{id}")
    public String removeReferee(@PathVariable("id") int id) {
        refereeServiceImp.removeReferee(id);
        return id+" referee deleted";
    }

    @PutMapping("/updateRefereeEventid/{referee_id}")
    public Referee updateReferreEvent_id(@PathVariable("referee_id") int referee_id,@RequestParam("event_id") int event_id) {
        return refereeServiceImp.updateReferreEvent_id(referee_id,event_id);
    }

    @PutMapping("/updateRefereeName/{referee_id}")
    public Referee updateRefereeName(@PathVariable("referee_id") int referee_id,@RequestParam("referee_Name") String referee_Name) {
        return refereeServiceImp.updateRefereeName(referee_id,referee_Name);
    }
}
