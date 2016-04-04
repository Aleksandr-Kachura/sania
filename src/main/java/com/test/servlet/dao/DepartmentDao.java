package com.test.servlet.dao;

import com.test.servlet.model.Department;

import java.util.List;

/**
 * Created by user on 04.04.16.
 */
public interface DepartmentDao {

    List<Department> findAll();

}
