package com.desafio.desafioneki.controller;

import org.springframework.web.bind.annotation.RestController;

import com.desafio.desafioneki.entity.Player;
import com.desafio.desafioneki.service.PlayerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping("/player")
public class controllerPlayer {
    @Autowired
    PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        return new ResponseEntity<>(playerService.getAllPlayers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable int id) {
        Player player = playerService.getPlayerById(id);

        if (player != null) { 
            return new ResponseEntity<>(player, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(player, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Player> savePlayer(@RequestBody Player player) {
         return new ResponseEntity<>(playerService.savePlayer(player), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable int id, @RequestBody Player player) {
         return new ResponseEntity<>(playerService.updatePlayer(player, id), HttpStatus.OK);

    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Player> deletePlayer (@PathVariable int id) {
        Player player = playerService.getPlayerById(id);

         if (player != null) { 
            return new ResponseEntity<>(playerService.deletePlayer(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(playerService.deletePlayer(id), HttpStatus.NOT_FOUND);
        }
    }   
}
