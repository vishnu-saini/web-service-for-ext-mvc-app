package com.incedo.accountapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.incedo.accountapp.dto.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
}