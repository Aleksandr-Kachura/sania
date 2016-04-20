package com.test.servlet.controller.dep;

import com.test.servlet.controller.InternalController;
import com.test.servlet.service.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Controller(value = "/showAllDep")
public class ShowAllDep implements InternalController {

    @Autowired
    private DepartmentServiceImpl depServ;

    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("departments", depServ.findAll());
            request.getRequestDispatcher("dep/all.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e.getMessage());
        }

    }
}
