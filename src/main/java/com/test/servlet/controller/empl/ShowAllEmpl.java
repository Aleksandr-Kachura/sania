package com.test.servlet.controller.empl;


import com.test.servlet.controller.InternalController;
import com.test.servlet.model.Department;
import com.test.servlet.model.Employee;
import com.test.servlet.service.DepartmentService;
import com.test.servlet.service.EmployeeService;
import com.test.servlet.service.impl.DepartmentServiceImpl;
import com.test.servlet.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ShowAllEmpl implements InternalController {


    private EmployeeService emplServ =  new EmployeeServiceImpl() ;


    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int depId = Integer.parseInt((request.getParameter("depId")));
        try {
            request.setAttribute("depId", depId );
            request.setAttribute("employees", emplServ.findAllEmployee(depId) );

        }catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("empl/all.jsp").forward(request, response);

    }
}
