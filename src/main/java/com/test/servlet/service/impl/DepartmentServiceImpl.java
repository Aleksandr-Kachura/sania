package com.test.servlet.service.impl;

import com.test.servlet.dao.DepartmentDao;
import com.test.servlet.dao.impl.DepartmentDaoImpl;
import com.test.servlet.model.Department;

import com.test.servlet.service.DepartmentService;

import java.util.List;

/**
 * Created by user on 04.04.16.
 */
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao = new DepartmentDaoImpl();


    public List<Department> findAll() {
        return departmentDao.findAll();
    }


    public void add()
    {
        Department model = new Department();
        model.setName("dsds");
        departmentDao.add(model);
    }

}
