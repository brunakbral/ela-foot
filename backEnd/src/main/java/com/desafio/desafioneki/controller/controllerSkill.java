package com.desafio.desafioneki.controller;

import org.springframework.web.bind.annotation.RestController;

import com.desafio.desafioneki.entity.Skill;
import com.desafio.desafioneki.service.SkillService;

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
@RequestMapping("/skill")
public class controllerSkill {
    @Autowired
    SkillService skillService;

    @GetMapping
    public ResponseEntity<List<Skill>> getAllSkills() {
        return new ResponseEntity<>(skillService.getAllSkills(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skill> getSkillById(@PathVariable int id) {
        Skill skill = skillService.getSkillById(id);

        if (skill != null) { 
            return new ResponseEntity<>(skill, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(skill, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Skill> saveSkill(@RequestBody Skill skill) {
         return new ResponseEntity<>(skillService.saveSkill(skill), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Skill> updateSkill(@PathVariable int id, @RequestBody Skill skill) {
         return new ResponseEntity<>(skillService.updateSkill(skill, id), HttpStatus.OK);

    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Skill> deleteSkill (@PathVariable int id) {
        Skill skill = skillService.getSkillById(id);

         if (skill != null) { 
            return new ResponseEntity<>(skillService.deleteSkill(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(skillService.deleteSkill(id), HttpStatus.NOT_FOUND);
        }
    }   
}
