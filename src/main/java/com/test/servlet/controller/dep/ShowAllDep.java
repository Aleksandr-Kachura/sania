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
import java.util.List;


public class ShowAllDep implements InternalController {

    private DepartmentService depServ =  new DepartmentServiceImpl() ;

    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("departments", depServ.findAll() );
          //  List<Department> list = depServ.findAll();
            request.getRequestDispatcher("dep/all.jsp").forward(request, response);
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
