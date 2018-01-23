package com.incedo.accountapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.incedo.accountapp.dao.UserDao;
import com.incedo.accountapp.dto.User;
import com.incedo.accountapp.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {


	@Autowired
	UserDao userDao;

	@Autowired
	MessageSource messageSource;

	@Override
	@Transactional(readOnly = true)
	public Page<User> getAllUsers(int page,int size) {
		Pageable pageable=new PageRequest(page, size);
		return userDao.findAll(pageable);
	}
	
	@Override
	public Page<User> getAllUsers(int page, int size, String sortProperty, Direction direction) {
		Sort sort=new Sort(direction, sortProperty);
		return userDao.findAll(new PageRequest(page, size, sort));
	}
	
	@Override
	public User addUser(User user) {
		return userDao.save(user);
	}
	@Override
	public User getUserById(int id) {
		return userDao.findOne(id);
	}
	@Override
	public User updateUser(User user) {
		return userDao.save(user);
	}

}
