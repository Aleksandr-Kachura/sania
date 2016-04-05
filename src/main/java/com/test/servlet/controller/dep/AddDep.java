package com.test.servlet.controller.dep;

import com.test.servlet.controller.InternalController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 05.04.16.
 */
public class AddDep implements InternalController {


    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("index3.jsp").forward(request, response);
    }
}
