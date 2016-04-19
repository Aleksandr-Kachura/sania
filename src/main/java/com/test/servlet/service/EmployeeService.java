package com.test.servlet.service;

import com.test.servlet.exception.ValidationException;
import com.test.servlet.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {

    List<Employee> findAllEmployee(Integer id) throws SQLException;



    void delete(Employee employee) throws SQLException;

    void saveOrUpdate(Employee employee) throws SQLException, ValidationException;

    Employee findEmployeeById(Integer id) throws SQLException;

    Employee findEmployeeByEmail(String email) throws SQLException;
}
