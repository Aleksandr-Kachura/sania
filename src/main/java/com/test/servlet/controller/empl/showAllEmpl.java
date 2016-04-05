package com.test.servlet.controller.empl;


import com.test.servlet.controller.InternalController;
import com.test.servlet.model.Department;
import com.test.servlet.service.DepartmentService;
import com.test.servlet.service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class showAllEmpl implements InternalController {


    private DepartmentService depServ =  new DepartmentServiceImpl() ;


    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt((request.getParameter("id")));

    }
}
