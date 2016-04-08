package com.test.servlet.controller.empl;


import com.test.servlet.controller.InternalController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddEmpl implements InternalController {



    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int depId = Integer.parseInt((request.getParameter("depId")));
        request.setAttribute("depId", depId );
        request.setAttribute("id", request.getParameter("id") );
        request.getRequestDispatcher("empl/create.jsp").forward(request, response);
    }
}