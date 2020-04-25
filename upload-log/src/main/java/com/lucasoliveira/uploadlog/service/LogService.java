package com.lucasoliveira.uploadlog.service;

import com.lucasoliveira.uploadlog.entity.Log;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public interface LogService {

    Log createOrUpdate(Log log);

    Page<Log> listLog(int page, int count);
}
