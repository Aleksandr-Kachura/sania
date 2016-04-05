package com.test.servlet.controller;

import com.test.servlet.dao.impl.DepartmentDaoImpl;
import com.test.servlet.service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
       req.setCharacterEncoding("UTF-8");
        //req.getRequestDispatcher("index2.jsp").forward(req, resp);//
       String str = req.getRequestURI();
        if (str.equals("/add")) {

            DepartmentServiceImpl depart = new DepartmentServiceImpl();
            depart.add();
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
        if (str.equals("/edit")) {
            req.getRequestDispatcher("index2.jsp").forward(req, resp);
        }



    }


    //req.getRequestDispatcher("index.jsp").forward(req, resp);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

}