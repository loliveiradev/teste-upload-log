package com.lucasoliveira.uploadlog.api.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.lucasoliveira.uploadlog.api.entity.User;
import com.lucasoliveira.uploadlog.api.repository.UserRepositoty;
import com.lucasoliveira.uploadlog.api.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepositoty userRepositoty;

	@Override
	public User findByEmail(String email) {
		return this.userRepositoty.findByEmail(email);
	}

	@Override
	public User createOrUpdate(User user) {
		return this.userRepositoty.save(user);
	}

	@Override
	public User findById(Long id) {
		return this.userRepositoty.findOne(id);
	}
		
	@Override
	public void delete(Long id) {
		this.userRepositoty.delete(id);
		
	}

	@Override
	public Page<User> findAll(int page, int count) {
        PageRequest pageRequest = new PageRequest(page- 1, count);
		return this.userRepositoty.findAll(pageRequest);
	}

}
