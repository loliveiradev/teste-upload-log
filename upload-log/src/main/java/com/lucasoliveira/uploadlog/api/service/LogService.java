package com.lucasoliveira.uploadlog.api.service;

import com.lucasoliveira.uploadlog.api.entity.Log;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public interface LogService {

    Log createOrUpdate(Log log);

    Page<Log> listLog(int page, int count);
}
