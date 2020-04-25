package com.lucasoliveira.uploadlog.api.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.lucasoliveira.uploadlog.api.entity.Log;

@Repository
public interface LogRepository extends  PagingAndSortingRepository<Log, Long>, 
JpaSpecificationExecutor<Log> {
	
	


}
