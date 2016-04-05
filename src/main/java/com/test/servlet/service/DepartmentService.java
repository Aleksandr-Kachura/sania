package com.test.servlet.service;

import com.test.servlet.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> findAll();

    void add(Department dep);
}
