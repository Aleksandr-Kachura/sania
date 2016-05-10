package com.test.servlet.controller;

import com.test.servlet.exception.ValidationException;
import com.test.servlet.model.Department;
import com.test.servlet.service.impl.DepartmentServiceImpl;
import com.test.servlet.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created on 21.04.16.
 */
@Controller

public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl depServ;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showInd() {
        return new ModelAndView("index");
    } //Object ModelAndView provide return both View and Model, return to handler

    @RequestMapping(value = "/DepAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Department> showAll() throws SQLException {

       // modelAndView.addObject("departments", depServ.findAll());
        return depServ.findAll();
    }

    //@RequestParam from jsp to controller
    @RequestMapping(value = "/delDep", method = RequestMethod.POST)
    @ResponseBody
    public List<Department> deleteOne(@RequestParam Integer Id) throws SQLException {
     /*   String direct = "";
        direct = "redirect:/page"; */// special char
        Department department;
        department = depServ.findDepartmentById(Id);
        depServ.delete(department);
        return depServ.findAll();
    }


    @RequestMapping(value = "/editOrAddDep")
    @ResponseBody
    public Department editOrAdd(@RequestParam(required = false) Integer id) throws SQLException {
        //ModelAndView modelAndView = new ModelAndView("/dep/create");
        Department department = null;
        if (id != null) {
            department = depServ.findDepartmentById(id);
          //  modelAndView.addObject("department", department);
        }

        return department;
    }


    @RequestMapping(value = "/depSaveOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse addNewOne(@RequestBody Department department) throws SQLException {
        JsonResponse result = new JsonResponse();
        try {
            depServ.saveOrUpdate(department);
            result.setStatus("SUCCESS");
            result.setDepartment(depServ.findAll());

        } catch (ValidationException e) {
            Map<String, String> error = e.getError();
            result.setError(error);
            result.setStatus("FAIL");

        }
        return result;
    }


}
