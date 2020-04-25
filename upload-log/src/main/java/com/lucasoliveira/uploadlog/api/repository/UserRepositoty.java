package com.lucasoliveira.uploadlog.api.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.lucasoliveira.uploadlog.api.entity.Log;
import com.lucasoliveira.uploadlog.api.entity.User;

public interface UserRepositoty extends PagingAndSortingRepository<User, Long>, 
JpaSpecificationExecutor<Log>{
	
	User findByEmail(String email);
	

}
