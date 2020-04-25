package com.lucasoliveira.uploadlog.service.impl;

import com.lucasoliveira.uploadlog.entity.Log;
import com.lucasoliveira.uploadlog.repository.LogRepository;
import com.lucasoliveira.uploadlog.service.LogService;
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
        Pageable pages = new PageRequest(page, count);
        return this.repository.findAll(pages);
    }
}
