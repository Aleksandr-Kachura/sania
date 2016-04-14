package com.test.servlet.controller.empl;


import com.test.servlet.controller.InternalController;
import com.test.servlet.model.Department;
import com.test.servlet.model.Employee;
import com.test.servlet.service.DepartmentService;
import com.test.servlet.service.EmployeeService;
import com.test.servlet.service.impl.DepartmentServiceImpl;
import com.test.servlet.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller(value = "/editEmpl")
public class EditEmpl implements InternalController {

    @Autowired
    private EmployeeService emplServ ;

    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt((request.getParameter("id")));
            int depId = Integer.parseInt((request.getParameter("depId")));
            request.setAttribute("employee", emplServ.findEmployeeById(id) );
            Employee emplo = emplServ.findEmployeeById(id);
            request.setAttribute("depId", depId );
            request.getRequestDispatcher("empl/create.jsp").forward(request, response);
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}