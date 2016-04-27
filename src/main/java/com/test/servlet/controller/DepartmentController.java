package com.test.servlet.controller;

import com.test.servlet.exception.ValidationException;
import com.test.servlet.model.Department;
import com.test.servlet.service.impl.DepartmentServiceImpl;
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

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ResponseBody
    public List<Department> showAll() throws SQLException {

       // modelAndView.addObject("departments", depServ.findAll());
        return depServ.findAll();
    }

    //@RequestParam from jsp to controller
    @RequestMapping(value = "/delDep", method = RequestMethod.POST)
    public String deleteOne(@RequestParam(required = true) Integer id) throws SQLException {
        String direct = "";
        direct = "redirect:/showAllDep"; // special char
        Department department;
        department = depServ.findDepartmentById(id);
        depServ.delete(department);
        return direct;
    }


    @RequestMapping(value = "/editOrAddDep")
    public ModelAndView editOrAdd(@RequestParam(required = false) Integer id) throws SQLException {
        ModelAndView modelAndView = new ModelAndView("/dep/create");
        Department department;
        if (id != null) {
            department = depServ.findDepartmentById(id);
            modelAndView.addObject("department", department);
        }

        return modelAndView;
    }


    //Understand Depertment by attribute
    @RequestMapping(value = "/depSaveOrUpdate", method = RequestMethod.POST)
    public ModelAndView addNewOne(Department department) throws SQLException {
        try {
            depServ.saveOrUpdate(department);
        } catch (ValidationException e) {
            ModelAndView modelAndView = new ModelAndView("/dep/create");
            Map<String, String> error = e.getError();
            modelAndView.addObject("department", department);
            modelAndView.addObject("error", error);
            return modelAndView;

        }
        return new ModelAndView("redirect:/showAllDep");
    }


}
