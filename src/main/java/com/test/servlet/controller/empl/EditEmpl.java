package com.test.servlet.controller.empl;


import com.test.servlet.controller.InternalController;
import com.test.servlet.model.Employee;
import com.test.servlet.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@Controller
public class EditEmpl implements InternalController {

    @Autowired
    private EmployeeService emplServ ;

    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String depIdParam = request.getParameter("depId");
        Integer depId = Integer.parseInt(depIdParam);
        String idParam = request.getParameter("id");
        if (!idParam.isEmpty()) {
            Integer id = Integer.parseInt(idParam);
            Employee employee ;
            try {
                employee = emplServ.findEmployeeById(id);
                request.setAttribute("employee",employee  );
                request.setAttribute("depId", depId );
                request.getRequestDispatcher("empl/create.jsp").forward(request, response);
            }catch (SQLException e) {
                throw new ServletException(e.getMessage());
            }
        }
        request.getRequestDispatcher("empl/create.jsp").forward(request, response);


    }
}