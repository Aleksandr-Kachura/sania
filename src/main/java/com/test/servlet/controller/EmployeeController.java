package com.test.servlet.controller;

import com.test.servlet.model.Employee;
import com.test.servlet.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;


/**
 * Created on 21.04.16.
 */
@Controller
public class EmployeeController {


    @Autowired
    private EmployeeServiceImpl emplServ;

    @RequestMapping(value = "/showAllEmpl", method = RequestMethod.GET)
    public ModelAndView showAll (@RequestParam(required = true) Integer depId) throws SQLException {
        List<Employee> employees;
        employees = emplServ.findAllEmployee(depId);
        ModelAndView modelAndView = new ModelAndView("/empl/all");
        modelAndView.addObject("employees", employees);
        modelAndView.addObject("depId", depId);
        return modelAndView;

    }

    @RequestMapping(value = "/delEmpl")
    public String deleteOne(@RequestParam(required = true) Integer id, @RequestParam(required = true) Integer depId) throws SQLException {
        Employee employee = emplServ.findEmployeeById(id);
        emplServ.delete(employee);
        return "redirect:/showAllEmpl?depId="+depId;
    }

}
