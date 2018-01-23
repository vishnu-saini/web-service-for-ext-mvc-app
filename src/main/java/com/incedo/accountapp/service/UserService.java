package com.incedo.accountapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import com.incedo.accountapp.dto.User;

public interface UserService {

	Page<User> getAllUsers(int page,int size);
	Page<User> getAllUsers(int page,int size,String sortProperty,Sort.Direction direction);
	public User addUser(User user);
	public User updateUser(User user);
	public User getUserById(int id);

}
