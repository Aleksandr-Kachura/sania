package com.test.servlet.controller;

import com.test.servlet.service.DepartmentService;
import com.test.servlet.service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 05.04.16.
 */
public class Test extends HttpServlet {

    private DepartmentService depServ =  new DepartmentServiceImpl() ;

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ControllerFactory factory = new ControllerFactory();
        InternalController contr =  factory.getControllerByName(req.getRequestURI());
        contr.doService(req, resp);
        //req.getRequestDispatcher("index2.jsp").forward(req, resp);//
       /* Connection connection = DBConnectionUtils.createConnection();
        try {
            String SQL = "insert into department (name) values (?)";
            PreparedStatement preparedStatement = connection.prepareStatement("insert into department(name) values (?)");
            preparedStatement.setString(1, "alex2");
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }*/

       /*String str = req.getRequestURI();
        if (str.equals("/add")) {
            Department dep = new Department();
            dep.setName("alex88");
            depServ.add(dep);
            // req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
        if (str.equals("/edit")) {
            req.getRequestDispatcher("index2.jsp").forward(req, resp);
        }*/



    }


    //req.getRequestDispatcher("index.jsp").forward(req, resp);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }


}
