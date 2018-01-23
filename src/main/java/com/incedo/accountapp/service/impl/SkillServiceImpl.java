package com.incedo.accountapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incedo.accountapp.dao.SkillDao;
import com.incedo.accountapp.dto.Skill;
import com.incedo.accountapp.service.SkillService;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {


	@Autowired
	SkillDao skillDao;

	@Autowired
	MessageSource messageSource;

	@Transactional(readOnly = true)
	public List<Skill> getAllSkills() {
		return skillDao.findAll();
	}
	
}
