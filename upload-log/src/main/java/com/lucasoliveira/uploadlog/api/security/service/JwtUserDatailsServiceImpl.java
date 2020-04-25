package com.lucasoliveira.uploadlog.api.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lucasoliveira.uploadlog.api.entity.User;
import com.lucasoliveira.uploadlog.api.security.wt.JwtUserFactory;
import com.lucasoliveira.uploadlog.api.service.UserService;

@Service
public class JwtUserDatailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserService userService; 
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user = userService.findByEmail(email);
		
		if (user == null) {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", email));
		}else {
			return JwtUserFactory.create(user);
		}
		
	}

}
