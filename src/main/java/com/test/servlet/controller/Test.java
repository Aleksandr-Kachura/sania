package com.test.servlet.controller;

import com.test.servlet.service.DepartmentService;
import com.test.servlet.service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 05.04.16.
 */
public class Test extends HttpServlet {

    private DepartmentService depServ =  new DepartmentServiceImpl() ;

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ControllerFactory factory = new ControllerFactory();
        InternalController contr =  factory.getControllerByName(req.getRequestURI());
        if( contr == null)
        {
             contr = factory.getDefaultController();
        }
        contr.doService(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }


}
