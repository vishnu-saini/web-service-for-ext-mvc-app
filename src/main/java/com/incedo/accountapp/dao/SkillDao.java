package com.incedo.accountapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.incedo.accountapp.dto.Skill;

@Repository
public interface SkillDao extends JpaRepository<Skill, Integer> {
}