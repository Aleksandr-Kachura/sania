package com.test.servlet.service;

import com.test.servlet.exception.ValidationException;
import com.test.servlet.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {

     List<Employee> findAllEmployee (int id) throws SQLException;

     void add(Employee empl) throws SQLException, ValidationException;

     void delete(Employee employee) throws SQLException;

     void update(Employee employee) throws SQLException, ValidationException;

     Employee findEmployeeById(int id) throws SQLException;

     Employee findEmployeeByEmail(String email) throws SQLException;
}
