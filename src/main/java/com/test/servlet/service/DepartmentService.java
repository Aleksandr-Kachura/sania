package com.test.servlet.service;

import com.test.servlet.exception.ValidationException;
import com.test.servlet.model.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentService {

    List<Department> findAll() throws SQLException;

    void add(Department dep) throws SQLException, ValidationException;

    void delete(Department dep) throws SQLException;

    void update(Department dep) throws SQLException, ValidationException;

    Department findDepartmentById(int id) throws SQLException;

    Department findDepartmentByName(String name) throws SQLException;
}
