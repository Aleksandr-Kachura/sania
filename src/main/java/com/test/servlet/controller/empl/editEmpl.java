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

public class editEmpl implements InternalController {

    private EmployeeService emplServ =  new EmployeeServiceImpl() ;

    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Employee empl = new Employee();
            int id = Integer.parseInt((request.getParameter("id")));
            request.setAttribute("employee", emplServ.findEmployeeById(id) );
            request.getRequestDispatcher("empl/create.jsp").forward(request, response);
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}