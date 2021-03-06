package com.test.servlet.controller.dep;

import com.test.servlet.controller.InternalController;
import com.test.servlet.exception.ValidationException;
import com.test.servlet.model.Department;
import com.test.servlet.service.DepartmentService;
import com.test.servlet.service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;


public class SaveDep implements InternalController {


    private DepartmentService depServ = new DepartmentServiceImpl();

    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Department dep = new Department();
        dep.setName(request.getParameter("name").trim());
        try {
            if (request.getParameter("id").isEmpty()) {

                depServ.add(dep);
            } else {
                dep.setId(Integer.valueOf(request.getParameter("id")));
                depServ.update(dep);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ValidationException e) {
            Map<String, String> error = e.getError();
            request.setAttribute("error", error);
            request.setAttribute("department", dep);
            request.getRequestDispatcher("dep/create.jsp").forward(request, response);
        }
        response.sendRedirect("/showAllDep");
    }
}