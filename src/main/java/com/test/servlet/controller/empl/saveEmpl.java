package com.test.servlet.controller.empl;

import com.test.servlet.controller.InternalController;

import com.test.servlet.model.Employee;

import com.test.servlet.service.EmployeeService;

import com.test.servlet.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class saveEmpl implements InternalController {


    private EmployeeService empServ =  new EmployeeServiceImpl();


    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Employee empl = new Employee();
            empl.setFirstName(request.getParameter("firstName"));
            empl.setSecondName(request.getParameter("secondName"));
            empl.setBirthday(Date.valueOf(request.getParameter("birthday")));
            empl.setDepId(Integer.parseInt((request.getParameter("depId"))));
            String str = request.getParameter("id");
            if(request.getParameter("id").isEmpty())
            {
                empServ.add(empl);
            }
            else
            {
                empl.setId(Integer.valueOf(request.getParameter("id")));
                empServ.update(empl);
            }
            empServ.add(empl);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        String url ="/showAllEmpl?depId="+request.getParameter("depId");
        response.sendRedirect(url);
      //  request.getRequestDispatcher("dep/create.jsp").forward(request, response);
    }
}