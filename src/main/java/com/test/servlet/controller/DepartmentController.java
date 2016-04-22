package com.test.servlet.controller;

import com.test.servlet.exception.ValidationException;
import com.test.servlet.model.Department;
import com.test.servlet.service.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
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
    }

    @RequestMapping(value = "/showAllDep", method = RequestMethod.GET)
    public ModelAndView showAll(HttpServletRequest request) throws SQLException {
        ModelAndView modelAndView = new ModelAndView("/dep/all");
        modelAndView.addObject("departments", depServ.findAll());
        return modelAndView;
    }


    @RequestMapping(value = "/delDep", method = RequestMethod.POST)
    public String deleteOne (@RequestParam(required = true) Integer id) throws SQLException {
        String direct = "";
        direct = "redirect:/showAllDep";
        Department department;
        department = depServ.findDepartmentById(id);
        depServ.delete(department);
        return direct;
    }



    @RequestMapping(value = "/editOrAddDep")
    public ModelAndView editOrAdd(@RequestParam(required = false) Integer id) throws SQLException {
        ModelAndView modelAndView = new ModelAndView("/dep/create");
        Department department;
        if(id != null)
        {
            department = depServ.findDepartmentById(id);
            modelAndView.addObject("department", department);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/depSaveOrUpdate", method = RequestMethod.POST)
    public ModelAndView addNewOne(@ModelAttribute Department department) throws SQLException
    {
       try {
            depServ.saveOrUpdate(department);
        }
        catch (ValidationException e)
        {
            ModelAndView modelAndView = new ModelAndView("/dep/create");
            Map<String, String> error = e.getError();
            modelAndView.addObject("department", department);
            modelAndView.addObject("error", error);
            return modelAndView;

        }
        return new ModelAndView("redirect:/showAllDep");
    }



}
