package com.lucasoliveira.uploadlog.api.service.impl;

import com.lucasoliveira.uploadlog.api.entity.Log;
import com.lucasoliveira.uploadlog.api.repository.LogRepository;
import com.lucasoliveira.uploadlog.api.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository repository;

    @Override
    public Log createOrUpdate(Log log) {
        return this.repository.save(log);
    }

    @Override
    public Page<Log> listLog(int page, int count) {
        PageRequest pageRequest = new PageRequest(page- 1, count);
        return this.repository.findAll(pageRequest);
    }
}
