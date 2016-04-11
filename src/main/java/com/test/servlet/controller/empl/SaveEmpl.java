package com.test.servlet.controller.empl;

import com.test.servlet.controller.InternalController;

import com.test.servlet.exception.ValidationException;
import com.test.servlet.model.Employee;

import com.test.servlet.service.EmployeeService;

import com.test.servlet.service.impl.EmployeeServiceImpl;
import com.test.servlet.util.ParseUtils;
import com.test.servlet.util.ValidatorUtils;
import net.sf.oval.Validator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


public class SaveEmpl implements InternalController {


    private EmployeeService empServ =  new EmployeeServiceImpl();
    private ParseUtils  parseUtil = new ParseUtils();


    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Employee empl = new Employee();
        empl.setFirstName(request.getParameter("firstName"));
        empl.setSecondName(request.getParameter("secondName"));

        Date birthday = parseUtil.parse(request.getParameter("birthday"));
        empl.setEmail(request.getParameter("email"));
        empl.setBirthday(birthday);
        empl.setDepId(Integer.parseInt((request.getParameter("depId"))));
        String id = request.getParameter("id");
        try {
            if(id.isEmpty() || id.contains("0"))
            {
                empServ.add(empl);
            }
            else
            {
                empl.setId(parseUtil.parseStrToInteger(request.getParameter("id")));
                empServ.update(empl);
            }

            String url ="/showAllEmpl?depId="+request.getParameter("depId");
            response.sendRedirect(url);
         }catch (SQLException e) {
            e.printStackTrace();
        }catch (ValidationException e)
        {
            Map<String, String> error = e.getError();
            request.setAttribute("error", error);
            request.setAttribute("depId", request.getParameter("depId"));
            request.setAttribute("id", id);
          //  empl.setId(parseUtil.parseStrToInteger(request.getParameter("id")));
            request.setAttribute("employee", empl );
            request.getRequestDispatcher("empl/create.jsp").forward(request, response);
        }

    }
}