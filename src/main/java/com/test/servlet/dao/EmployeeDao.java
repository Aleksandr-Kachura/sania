package com.test.servlet.dao;



import com.test.servlet.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao{

    List<Employee> findAllEmployee(int id) throws SQLException;
    void add(Employee model) throws SQLException;
    void delete(Employee model) throws SQLException;
    Employee findEmployeeById(int id) throws SQLException;
    void update(Employee model) throws SQLException;
    Employee findEmployeeByEmail(String email) throws SQLException;
}