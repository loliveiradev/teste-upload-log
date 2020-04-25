package com.lucasoliveira.uploadlog.controller;

import com.lucasoliveira.uploadlog.entity.Log;
import com.lucasoliveira.uploadlog.response.Response;
import com.lucasoliveira.uploadlog.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1/log")
@CrossOrigin(origins="*")
public class LogController {

    @Autowired
    private LogService service;

    public ResponseEntity<Response<Log>> createOrUpade (HttpServletRequest request,
                                                        @RequestBody Log log, BindingResult result){

        Response<Log> response = new Response<Log>();

        try {
            validateCreateLog(log, result);
            if (result.hasErrors()) {
                result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
                return ResponseEntity.badRequest().body(response);
            }

            Log ticketPersisted = (Log) service.createOrUpdate(log);
            response.setData(ticketPersisted);
        } catch (Exception e) {
            response.getErrors().add(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);

    }

    private void validateCreateLog(Log log, BindingResult result) {
        if (log.getDate() == null) {
            result.addError(new ObjectError("Ticket", "Title no information"));
            return;
        }

    }


    @GetMapping(value = "{page}/{count}")
    public ResponseEntity<Response<Page<Log>>> findAll (HttpServletRequest request, @PathVariable("page") int page, @PathVariable("count") int count){
        Response<Page<Log>> response = new Response<Page<Log>>();
        Page<Log> tickets = null;
        tickets = service.listLog(page, count);
        response.setData(tickets);
        return ResponseEntity.ok(response);
    }



}
