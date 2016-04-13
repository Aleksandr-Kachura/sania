package com.test.servlet.controller;

import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public interface InternalController{

    void  doService(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException;
}
