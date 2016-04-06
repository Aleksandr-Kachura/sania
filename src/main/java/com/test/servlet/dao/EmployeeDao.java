package com.test.servlet.dao;


import com.test.servlet.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao{

    List<Employee> findAllEmployee(int id) throws SQLException;


}