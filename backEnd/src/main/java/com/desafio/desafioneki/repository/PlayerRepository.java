package com.desafio.desafioneki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.desafioneki.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>  {
    
}
