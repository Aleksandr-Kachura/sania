package com.test.servlet.controller.dep;

import com.test.servlet.controller.InternalController;
import com.test.servlet.model.Department;
import com.test.servlet.service.DepartmentService;
import com.test.servlet.service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class saveDep implements InternalController {


    private DepartmentService depServ =  new DepartmentServiceImpl() ;


    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Department dep = new Department();
            dep.setName(request.getParameter("name"));
            depServ.add(dep);
        }catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/showAllDep");
      //  request.getRequestDispatcher("dep/create.jsp").forward(request, response);
    }
}