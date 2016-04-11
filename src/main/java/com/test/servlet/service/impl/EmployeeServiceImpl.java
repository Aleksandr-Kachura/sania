package com.test.servlet.service.impl;


import com.test.servlet.dao.EmployeeDao;
import com.test.servlet.dao.impl.EmployeeDaoImpl;
import com.test.servlet.model.Employee;
import com.test.servlet.service.EmployeeService;

import java.sql.SQLException;
import java.util.List;


public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao = new EmployeeDaoImpl();


    public List<Employee> findAllEmployee (int id) throws SQLException
    {
       return employeeDao.findAllEmployee(id);
    }

    public void add (Employee empl) throws SQLException{
        employeeDao.add(empl);
    }

    public void delete (Employee empl) throws SQLException{employeeDao.delete(empl); }

    public void update (Employee empl) throws SQLException{employeeDao.update(empl); }

    public Employee findEmployeeById (int id) throws SQLException
    {
        return employeeDao.findEmployeeById(id);
    }

    public Employee findEmployeeByEmail(String email) throws SQLException
    {
        return employeeDao.findEmployeeByEmail(email);
    }


}
