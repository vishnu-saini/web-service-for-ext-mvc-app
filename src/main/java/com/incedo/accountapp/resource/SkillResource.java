/*
 * 
 */
package com.incedo.accountapp.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.incedo.accountapp.dto.Skill;
import com.incedo.accountapp.responsebean.RootResponse;
import com.incedo.accountapp.service.SkillService;

@CrossOrigin
@RestController
@RequestMapping("api/skill")
public class SkillResource {

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(SkillResource.class);

	@Autowired
	private SkillService skillService;

	@RequestMapping(method = RequestMethod.GET, params = {}, produces = MediaType.APPLICATION_JSON_VALUE)
	public RootResponse<List<Skill>> getAllUsers() throws Exception {
		return new RootResponse<List<Skill>>(true, skillService.getAllSkills());
	}

}
