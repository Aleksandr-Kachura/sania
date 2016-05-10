package com.test.servlet.controller;


import com.test.servlet.exception.ValidationException;
import com.test.servlet.model.Department;
import com.test.servlet.model.Employee;
import com.test.servlet.service.impl.DepartmentServiceImpl;
import com.test.servlet.service.impl.EmployeeServiceImpl;
import com.test.servlet.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {


    @Autowired
    private EmployeeServiceImpl emplServ;

    @Autowired
    private DepartmentServiceImpl depServ;


    @InitBinder //for ini WebdataBinder(from request parameter to JavaBean objects)
    public void initBinder(WebDataBinder binder) {
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }

    @RequestMapping(value = "/showAllEmpl", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> showAll(@RequestParam(required = true) Integer Id) throws SQLException {
        List<Employee> employees;
        employees = emplServ.findAllEmployee(Id);
        return employees;

    }

    @RequestMapping(value = "/delEmpl")
    @ResponseBody
    public List<Employee> deleteOne(@RequestParam(required = true) Integer id, @RequestParam(required = true) Integer depId) throws SQLException {
        Employee employee = emplServ.findEmployeeById(id);
        emplServ.delete(employee);
        return emplServ.findAllEmployee(depId);
    }

    @RequestMapping(value = "/editOrAddEmpl")
    @ResponseBody
    public Employee editOrAddEmpl(@RequestParam(required = false) Integer id) throws SQLException {
        Employee employee = new Employee();
        if (id != null) {
            employee = emplServ.findEmployeeById(id);
        }
        return employee;
    }


    @RequestMapping(value = "/employeeSaveOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse employeeSaveOrUpdate(@RequestParam("depId") Integer depId, @RequestBody Employee employee) throws SQLException {
        JsonResponse result = new JsonResponse();
        Department department = depServ.findDepartmentById(depId);
        employee.setDepartment(department);
        try {
            emplServ.saveOrUpdate(employee);
            result.setStatus("SUCCESS");
            result.setEmployee(emplServ.findAllEmployee(depId));
        } catch (ValidationException e) {
            Map<String, String> error = e.getError();
            result.setError(error);
            result.setStatus("FAIL");
        }

        return result;
    }

}
