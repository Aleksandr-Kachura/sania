package com.test.servlet.controller.dep;

import com.test.servlet.controller.InternalController;
import com.test.servlet.exception.ValidationException;
import com.test.servlet.model.Department;
import com.test.servlet.service.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@Controller(value = "/saveDep")
public class SaveDep implements InternalController {


    @Autowired
    private DepartmentServiceImpl depServ;

    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Department dep = new Department();
        dep.setName(request.getParameter("name").trim());
        try {
            if (!request.getParameter("id").isEmpty()) {
                dep.setId(Integer.valueOf(request.getParameter("id")));
            }
            depServ.saveOrUpdate(dep);
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