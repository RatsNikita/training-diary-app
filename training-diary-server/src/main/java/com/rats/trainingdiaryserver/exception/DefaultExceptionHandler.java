package com.rats.trainingdiaryserver.exception;


import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.tomcat.util.json.JSONParser;
import org.hibernate.exception.ConstraintViolationException;
import org.json.JSONObject;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice(basePackages = "com.rats.trainingdiaryserver.controller")
@CommonsLog
public class DefaultExceptionHandler {



    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> handlerConstraintViolationException(ConstraintViolationException exception) {
        String response = new JSONObject()
                .put("message","Exercise with same name already exist")
                .toString();
        return ResponseEntity.badRequest().body(response);
         //       .header("message","Exercise with same name already exist")
    }



}
