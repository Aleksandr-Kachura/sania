package com.test.servlet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ValidationException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created on 05.04.16.
 */
//take delegation from HttpRequestHandlerServlet
@Controller(value = "main")
public class MainServ implements HttpRequestHandler {

    @Autowired
    private ApplicationContext applicationContext; //provide work with setting

    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        InternalController servlet =(InternalController) applicationContext.getBean(url);

        servlet.doService(request,response);



    }
}
