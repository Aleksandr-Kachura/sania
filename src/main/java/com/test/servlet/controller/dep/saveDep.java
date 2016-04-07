package com.test.servlet.controller.dep;

import com.test.servlet.controller.InternalController;
import com.test.servlet.exception.ValidationException;
import com.test.servlet.model.Department;
import com.test.servlet.service.DepartmentService;
import com.test.servlet.service.impl.DepartmentServiceImpl;
import com.test.servlet.util.ValidatorUtils;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class saveDep implements InternalController {


    private DepartmentService depServ =  new DepartmentServiceImpl() ;


    public void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Department dep = new Department();
            ValidatorUtils util = new ValidatorUtils();
            dep.setName(request.getParameter("name"));
            if(request.getParameter("id").isEmpty())
            {

                util.validate(dep);
                depServ.add(dep);
            }
            else
            {
                dep.setId(Integer.valueOf(request.getParameter("id")));
                util.validate(dep);
                depServ.update(dep);
            }

           /* try {
                ValidatorUtils util = new ValidatorUtils();
                util.validate(dep);
            }catch (ValidationException e)
            {
                Map<String,String> error = e.getError();
                request.setAttribute("error", error );
                request.getRequestDispatcher("dep/create.jsp").forward(request, response);

            }*/
        }catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ValidationException e) {
            Map<String, String> error = e.getError();
            request.setAttribute("error", error);
            request.getRequestDispatcher("dep/create.jsp").forward(request, response);
        }


            response.sendRedirect("/showAllDep");
      //  request.getRequestDispatcher("dep/create.jsp").forward(request, response);
    }
}