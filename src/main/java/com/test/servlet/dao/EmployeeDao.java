package com.test.servlet.dao;


import com.test.servlet.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {

    List<Employee> findAllEmployee(Integer id) throws SQLException;


    void delete(Employee model) throws SQLException;

    Employee findEmployeeById(Integer id) throws SQLException;


    void saveOrUpdate(Employee model) throws SQLException;

    Employee findEmployeeByEmail(String email) throws SQLException;
}