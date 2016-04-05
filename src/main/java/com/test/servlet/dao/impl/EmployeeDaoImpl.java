package com.test.servlet.dao.impl;

import com.test.servlet.dao.DepartmentDao;
import com.test.servlet.dao.EmployeeDao;
import com.test.servlet.model.Department;
import com.test.servlet.util.DBConnectionUtils;

import java.sql.Connection;
import java.util.List;

/**
 * Created by user on 04.04.16.
 */
public class EmployeeDaoImpl implements EmployeeDao {


    public List<Department> findAll() {
        Connection connection = DBConnectionUtils.createConnection();

        return null;
    }
}
