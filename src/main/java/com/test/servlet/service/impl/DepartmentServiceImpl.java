package com.test.servlet.service.impl;

import com.test.servlet.dao.DepartmentDao;
import com.test.servlet.dao.impl.DepartmentDaoImpl;
import com.test.servlet.model.Department;

import com.test.servlet.service.DepartmentService;

import java.util.List;


public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao = new DepartmentDaoImpl();


    public List<Department> findAll() {
        return departmentDao.findAll();
    }


    public Department findDepartmentById(int id) {
        return departmentDao.findDepartmentById(id);
    }

    public void add (Department dep) {
        departmentDao.add(dep);
    }

    public void delete (Department dep) {departmentDao.delete(dep); }

}
