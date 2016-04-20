package com.test.servlet.controller.empl;


import com.test.servlet.controller.InternalController;
import com.test.servlet.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Controller(value = "/showAllEmpl")
public class ShowAllEmpl implements InternalController {


    @Autowired
    private EmployeeServiceImpl emplServ;


    public void doService(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        String depIdParam = request.getParameter("depId");
        Integer depId = Integer.parseInt(depIdParam);
        try {
            request.setAttribute("depId", depId);
            request.setAttribute("employees", emplServ.findAllEmployee(depId));

        } catch (SQLException e) {
            throw new ServletException(e.getMessage());
        }
        request.getRequestDispatcher("empl/all.jsp").forward(request, response);

    }
}
