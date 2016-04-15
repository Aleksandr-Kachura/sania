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


    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int depId = Integer.parseInt((request.getParameter("depId")));
        try {
            request.setAttribute("depId", depId);
            request.setAttribute("employees", emplServ.findAllEmployee(depId));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("empl/all.jsp").forward(request, response);

    }
}
