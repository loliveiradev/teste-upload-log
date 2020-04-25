package com.lucasoliveira.uploadlog.repository;

import com.lucasoliveira.uploadlog.entity.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<Log,Long> {

    Page<Log> findAll(Pageable pageable);

}
