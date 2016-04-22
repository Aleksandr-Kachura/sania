package com.test.servlet.controller.dep;


import com.test.servlet.controller.InternalController;
import com.test.servlet.model.Department;
import com.test.servlet.service.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Controller
public class DelDep implements InternalController {


    @Autowired
    private DepartmentServiceImpl depServ;


    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Department dep;
        String idParam = request.getParameter("id");
        Integer id = Integer.parseInt(idParam);
        try {
            dep = depServ.findDepartmentById(id);
            depServ.delete(dep);

        } catch (SQLException e) {
            throw new ServletException(e.getMessage());
        }


        response.sendRedirect("/showAllDep");
    }
}