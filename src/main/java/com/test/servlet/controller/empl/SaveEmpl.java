package com.test.servlet.controller.empl;

import com.test.servlet.controller.InternalController;
import com.test.servlet.exception.ValidationException;
import com.test.servlet.model.Department;
import com.test.servlet.model.Employee;
import com.test.servlet.service.impl.DepartmentServiceImpl;
import com.test.servlet.service.impl.EmployeeServiceImpl;
import com.test.servlet.util.ParseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

@Controller
public class SaveEmpl implements InternalController {

    @Autowired
    private EmployeeServiceImpl emplServ;

    @Autowired
    private ParseUtils parseUtil;

    @Autowired
    private DepartmentServiceImpl depServ;


    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Employee empl = new Employee();

        String depIdParam = request.getParameter("depId");
        Integer depId = Integer.parseInt(depIdParam);
        String idParam = request.getParameter("id");


        empl.setFirstName(request.getParameter("firstName"));
        empl.setSecondName(request.getParameter("secondName"));
        empl.setEmail(request.getParameter("email"));
        Department dep;

        String dateParam = request.getParameter("birthday");
        Date birthday = parseUtil.parse(dateParam);

        empl.setBirthday(birthday);

        try {
            dep = depServ.findDepartmentById(depId);
            empl.setDepartment(dep);

            if (!idParam.isEmpty()) {
                Integer id = Integer.parseInt(idParam);
                empl.setId(id);
            }
            emplServ.saveOrUpdate(empl);
            String url = "/showAllEmpl?depId=" + depIdParam;
            response.sendRedirect(url);
        } catch (SQLException e) {
            throw new ServletException(e.getMessage());
        } catch (ValidationException e) {
            Map<String, String> error = e.getError();
            request.setAttribute("error", error);
            request.setAttribute("depId", depIdParam);
            request.setAttribute("id", idParam);
            request.setAttribute("employee", empl);
            request.getRequestDispatcher("empl/create.jsp").forward(request, response);
        }

    }
}