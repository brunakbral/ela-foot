package com.desafio.desafioneki.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.desafioneki.entity.Skill;
import com.desafio.desafioneki.repository.SkillRepository;

@Service
public class SkillService {
     @Autowired
    SkillRepository skillRepository;

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }
    public Skill getSkillById(int id){
        return skillRepository.findById(id).orElse(null);
    }
    public Skill saveSkill(Skill skill){
        return skillRepository.save(skill);
    }
    public Skill updateSkill(Skill skill, int id){
        Skill oldSkill = getSkillById(id);

        oldSkill.setOffense(skill.getOffense());
        oldSkill.setDefense(skill.getDefense());
        oldSkill.setPassing(skill.getPassing());
        oldSkill.setDribbling(skill.getDribbling());
        oldSkill.setPositioning(skill.getPositioning());
        oldSkill.setHability(skill.getHability());

        oldSkill.setTeamWork(skill.getTeamWork());
        oldSkill.setConcentration(skill.getConcentration());
        oldSkill.setLeadership(skill.getLeadership());
        oldSkill.setBravery(skill.getBravery());
        oldSkill.setComposure(skill.getComposure());
        oldSkill.setDecisions(skill.getDecisions());

        oldSkill.setStrength(skill.getStrength());
        oldSkill.setReflexes(skill.getReflexes());
        oldSkill.setJumping(skill.getJumping());
        oldSkill.setCardio(skill.getCardio());
        oldSkill.setBalance(skill.getBalance());
        oldSkill.setAcceleration(skill.getAcceleration());

        return saveSkill(oldSkill);
    }
    public Skill deleteSkill(int id){
        skillRepository.deleteById(id);
        return getSkillById(id);
    }
}
