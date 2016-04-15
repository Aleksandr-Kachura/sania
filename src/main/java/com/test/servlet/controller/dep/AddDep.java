package com.test.servlet.controller.dep;


import com.test.servlet.controller.InternalController;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller(value = "/addDep")
public class AddDep implements InternalController {



    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("dep/create.jsp").forward(request, response);
    }
}