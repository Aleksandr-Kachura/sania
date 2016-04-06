package com.test.servlet.dao.impl;

import com.test.servlet.dao.DepartmentDao;
import com.test.servlet.dao.EmployeeDao;
import com.test.servlet.model.Department;
import com.test.servlet.model.Employee;
import com.test.servlet.util.DBConnectionUtils;
import sun.invoke.empty.Empty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 04.04.16.
 */
public class EmployeeDaoImpl implements EmployeeDao {


    public List<Department> findAll() {
        Connection connection = DBConnectionUtils.createConnection();

        return null;
    }

    public List<Employee> findAllEmployee (int id) throws SQLException {
        Connection connection = DBConnectionUtils.createConnection();
        List<Employee> employees = new ArrayList<Employee>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where id=?");

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
           } finally {
            connection.close();
        }
        return employees;
    }

     /*public List<Employee> findAllEmployee (int id) throws SQLException {
        Connection connection = DBConnectionUtils.createConnection();
        List<Employee> employees = new ArrayList<Employee>();
        Department department = new Department();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where id=?");

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
            }

        } finally {
            connection.close();
        }


        return employees;
    }*/
}
