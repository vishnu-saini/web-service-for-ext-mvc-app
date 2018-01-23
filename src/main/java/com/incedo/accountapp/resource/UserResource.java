/*
 * 
 */
package com.incedo.accountapp.resource;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.incedo.accountapp.dto.User;
import com.incedo.accountapp.responsebean.RootResponse;
import com.incedo.accountapp.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("api/user")
public class UserResource {

	/** The logger. */
	private final Logger logger = LoggerFactory.getLogger(UserResource.class);

	/** The user service. */
	@Autowired
	private UserService userService;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RootResponse<String> addUser(@RequestBody User user) throws Exception {
		System.out.println(user);
		userService.addUser(user);
		return new RootResponse<String>(true, messageSource.getMessage("success.user.added", null, Locale.US));

	}

	@RequestMapping(method = RequestMethod.GET, params = { "page", "limit",
			"start" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public RootResponse<Page<User>> getAllUsers(@RequestParam("page") int page, @RequestParam("limit") int limit,
			@RequestParam("start") int start, @RequestParam(name = "sort", required = false) String sort)
			throws Exception {
		System.out.println(sort);
		Page<User> users;
		String sortProperty = null;
		String sortDirection = null;
		Direction direction=null;
		page--;
		if (sort != null) {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode rootNode = objectMapper.readTree(sort);
			Iterator<JsonNode> elements = rootNode.elements();
			while (elements.hasNext()) {
				JsonNode node = elements.next();
				sortProperty = node.path("property").asText();
				sortDirection = node.path("direction").asText();
			}
			if (sortDirection.equals("ASC"))
				direction = Direction.ASC;
			if (sortDirection.equals("DESC"))
				direction = Direction.DESC;
			users = userService.getAllUsers(page, limit, sortProperty, direction);
		} else {
			users = userService.getAllUsers(page, limit);
		}
		System.out.println(users);
		return new RootResponse<Page<User>>(true, users);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RootResponse<String> updateUser(@RequestBody User user, @PathVariable int id) throws Exception {
		System.out.println(user);

		user.setId(id);
		userService.addUser(user);
		return new RootResponse<String>(true, messageSource.getMessage("success.user.added", null, Locale.US));

	}

}
