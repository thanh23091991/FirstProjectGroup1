package com.studentmanager.service;

import org.springframework.data.repository.CrudRepository;

import com.studentmanager.entity.Users;

public interface UsersService extends CrudRepository<Users, Long> {
	public Users findByEmailAndPassword(String email, String password);
}
