package com.desafio.desafioneki.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.desafioneki.entity.Player;
import com.desafio.desafioneki.repository.PlayerRepository;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
    public Player getPlayerById(int id){
        return playerRepository.findById(id).orElse(null);
    }
    public Player savePlayer(Player player){
        return playerRepository.save(player);
    }
    public Player updatePlayer(Player player, int id){
        Player oldPlayer = getPlayerById(id);

        oldPlayer.setName(player.getName());
        oldPlayer.setPosition(player.getPosition());
        oldPlayer.setImg(player.getImg());
        oldPlayer.setPoints(player.getPoints());
        oldPlayer.setAge(player.getAge());
        oldPlayer.setWeight(player.getWeight());
        oldPlayer.setHeight(player.getHeight());
        oldPlayer.setSkill(player.getSkill());

        return savePlayer(oldPlayer);
    }
    public Player deletePlayer(int id){
        playerRepository.deleteById(id);
        return getPlayerById(id);
    }
}
