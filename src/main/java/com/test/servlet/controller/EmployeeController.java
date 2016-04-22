package com.test.servlet.controller;


import com.test.servlet.exception.ValidationException;
import com.test.servlet.model.Department;
import com.test.servlet.model.Employee;
import com.test.servlet.service.impl.DepartmentServiceImpl;
import com.test.servlet.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


/**
 * Created on 21.04.16.
 */
@Controller
public class EmployeeController {


    @Autowired
    private EmployeeServiceImpl emplServ;

    @Autowired
    private DepartmentServiceImpl depServ;


    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }

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

    @RequestMapping(value = "/editOrAddEmpl")
    public ModelAndView editOrAddEmpl(@RequestParam(required = false) Integer id, @RequestParam(required = true) Integer depId) throws SQLException
    {
        ModelAndView modelAndView = new ModelAndView("/empl/create");
        Employee employee = new Employee();
        if(id != null)
        {
            employee = emplServ.findEmployeeById(id);

        }
        modelAndView.addObject("employee", employee);
        modelAndView.addObject("depId",  depId);
        return modelAndView;
    }


    @RequestMapping(value = "/employeeSaveOrUpdate")
    public ModelAndView employeeSaveOrUpdate(@ModelAttribute Employee employee, @RequestParam(required = true) Integer depId) throws  SQLException
    {
        Employee empl = employee;
        ModelAndView modelAndView ;
        Department department = depServ.findDepartmentById(depId);
        empl.setDepartment(department);
        try {

            emplServ.saveOrUpdate(empl);
        }
        catch (ValidationException e)
        {
            modelAndView = new ModelAndView("/empl/create");
            Map<String, String> error = e.getError();
            modelAndView.addObject("depId",depId);
            modelAndView.addObject("employee", employee);
            modelAndView.addObject("error", error);
            return modelAndView;

        }

        modelAndView = new ModelAndView("redirect:/showAllEmpl");
        modelAndView.addObject("depId",depId);
        return modelAndView;
    }

}
