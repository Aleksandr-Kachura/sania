package com.test.servlet.controller.empl;


import com.test.servlet.controller.InternalController;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Controller(value = "/addEmpl")
public class AddEmpl implements InternalController {



    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int depId = Integer.parseInt((request.getParameter("depId")));
        request.setAttribute("depId", depId );
        request.getRequestDispatcher("empl/create.jsp").forward(request, response);
    }
}