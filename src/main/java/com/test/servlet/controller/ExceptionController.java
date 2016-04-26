package com.test.servlet.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

/**
 * Created on 26.04.16.
 */
@ControllerAdvice  //autodetected
public class ExceptionController {


    @ExceptionHandler(SQLException.class)
    public ModelAndView databaseError() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("noCopyPast");
        return modelAndView;
    }

}
