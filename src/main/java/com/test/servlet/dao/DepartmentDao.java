package com.test.servlet.dao;

import com.test.servlet.model.Department;

import java.sql.SQLException;
import java.util.List;


public interface DepartmentDao {

    List<Department> findAll() throws SQLException;

    Department findDepartmentById(Integer id) throws SQLException;

    Department findDepartmentByName(String name) throws SQLException;

    void saveOrUpdate(Department model) throws SQLException;

    void delete(Department model) throws SQLException ;


}
