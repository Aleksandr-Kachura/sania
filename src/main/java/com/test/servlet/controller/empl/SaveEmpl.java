package com.test.servlet.controller.empl;

import com.test.servlet.controller.InternalController;
import com.test.servlet.exception.ValidationException;
import com.test.servlet.model.Employee;
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

@Controller(value = "/saveEmpl")
public class SaveEmpl implements InternalController {

    @Autowired
    private EmployeeServiceImpl emplServ;

    @Autowired
    private ParseUtils parseUtil;


    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Employee empl = new Employee();
        empl.setFirstName(request.getParameter("firstName"));
        empl.setSecondName(request.getParameter("secondName"));

        Date birthday = parseUtil.parse(request.getParameter("birthday"));
        empl.setEmail(request.getParameter("email"));
        empl.setBirthday(birthday);
        empl.setDepId(Integer.parseInt((request.getParameter("depId"))));
       try {
            if (!request.getParameter("id").isEmpty()) {
                empl.setId(parseUtil.parseStrToInteger(request.getParameter("id")));
            }
            emplServ.saveOrUpdate(empl);
            String url = "/showAllEmpl?depId=" + request.getParameter("depId");
            response.sendRedirect(url);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ValidationException e) {
            Map<String, String> error = e.getError();
            request.setAttribute("error", error);
            request.setAttribute("depId", request.getParameter("depId"));
            request.setAttribute("id", request.getParameter("id"));
            request.setAttribute("employee", empl);
            request.getRequestDispatcher("empl/create.jsp").forward(request, response);
        }

    }
}