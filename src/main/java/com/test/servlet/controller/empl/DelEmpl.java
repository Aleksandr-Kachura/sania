package com.test.servlet.controller.empl;


import com.test.servlet.controller.InternalController;
import com.test.servlet.model.Employee;
import com.test.servlet.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Controller
public class DelEmpl implements InternalController {


    @Autowired
    private EmployeeServiceImpl emplServ;

    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        Integer id = Integer.parseInt(idParam);
        Employee empl;
        try {
            empl = emplServ.findEmployeeById(id);
            emplServ.delete(empl);
        } catch (SQLException e) {
            throw new ServletException(e.getMessage());
        }
        String url = "/showAllEmpl?depId=" + request.getParameter("depId");
        response.sendRedirect(url);
    }
}