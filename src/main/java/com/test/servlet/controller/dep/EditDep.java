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

@Controller(value = "/editDep")
public class EditDep implements InternalController {

    @Autowired
    private DepartmentServiceImpl depServ  ;

    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt((request.getParameter("id")));
            request.setAttribute("department", depServ.findDepartmentById(id) );
            request.getRequestDispatcher("dep/create.jsp").forward(request, response);
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}