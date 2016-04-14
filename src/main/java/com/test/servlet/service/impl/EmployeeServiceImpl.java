package com.test.servlet.service.impl;


import com.test.servlet.dao.EmployeeDao;
import com.test.servlet.dao.impl.hiber.EmployeeDaoImpl;
import com.test.servlet.exception.ValidationException;
import com.test.servlet.model.Employee;
import com.test.servlet.service.EmployeeService;
import com.test.servlet.util.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDaoImpl employeeDao ;


    private ValidatorUtils util = new ValidatorUtils();

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAllEmployee(int id) throws SQLException {
        return employeeDao.findAllEmployee(id);
    }

    /** @deprecated */
    public void add(Employee empl) throws SQLException, ValidationException {
        util.validate(empl);
        employeeDao.add(empl);
    }

    @Override
    @Transactional
    public void delete(Employee empl) throws SQLException {
        employeeDao.delete(empl);
    }
    /** @deprecated */
    public void update(Employee empl) throws SQLException, ValidationException  {
        util.validate(empl);
        employeeDao.update(empl);
    }

    @Override
    @Transactional
    public Employee findEmployeeById(int id) throws SQLException {
        return employeeDao.findEmployeeById(id);
    }

    @Override
    @Transactional
    public Employee findEmployeeByEmail(String email) throws SQLException {
        return employeeDao.findEmployeeByEmail(email);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Employee empl) throws SQLException, ValidationException
    {
        util.validate(empl);
        employeeDao.saveOrUpdate(empl);
    }


}
