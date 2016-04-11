package com.test.servlet.dao.impl;

import com.test.servlet.dao.DepartmentDao;
import com.test.servlet.dao.EmployeeDao;
import com.test.servlet.model.Department;
import com.test.servlet.model.Employee;
import com.test.servlet.util.DBConnectionUtils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDaoImpl implements EmployeeDao {


     public List<Employee> findAllEmployee (int id) throws SQLException {
        Connection connection = DBConnectionUtils.createConnection();
        List<Employee> employees = new ArrayList<Employee>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where depId=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setFirstName(rs.getString("firstName"));
                employee.setSecondName(rs.getString("secondName"));
                employee.setBirthday(rs.getDate("birthday"));
                employee.setDepId(rs.getInt("depId"));
                employee.setEmail(rs.getString("email"));
                employees.add(employee);
            }

           } finally {
            connection.close();
        }
        return employees;
    }

    public void delete(Employee model) throws SQLException
    {
        Connection connection = DBConnectionUtils.createConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from employee where id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, model.getId());
            preparedStatement.executeUpdate();

        } finally {
            connection.close();
        }
    }



    public void add(Employee model) throws SQLException {

        Connection connection = DBConnectionUtils.createConnection();
        try {
            String SQL = "insert into employee (firstName,secondName,birthday,depId,email) values (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, model.getFirstName());
            preparedStatement.setString(2, model.getSecondName());
            preparedStatement.setDate(3, new java.sql.Date(model.getBirthday().getTime()));
            preparedStatement.setInt(4, model.getDepId());
            preparedStatement.setString(5, model.getEmail());
            preparedStatement.executeUpdate();
        }finally {
            connection.close();
        }

    }



    public void update(Employee employee) throws SQLException{

        Connection connection = DBConnectionUtils.createConnection();
        String sql = "UPDATE employee SET firstName = ?, secondName = ?, birthday = ?, email = ?   WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getSecondName());
            preparedStatement.setDate(3, new java.sql.Date(employee.getBirthday().getTime()));
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setInt(5, employee.getId());
            preparedStatement.executeUpdate();

        }finally {
            connection.close();
        }

    }


   public Employee findEmployeeById(int id) throws SQLException
    {
        Connection connection = DBConnectionUtils.createConnection();
        Employee employee = new Employee();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                employee.setId(rs.getInt("id"));
                employee.setFirstName(rs.getString("firstName"));
                employee.setSecondName(rs.getString("secondName"));
                employee.setBirthday(rs.getDate("birthday"));
                employee.setDepId(rs.getInt("depId"));
                employee.setEmail(rs.getString("email"));
            }

        }finally {
            connection.close();
        }
        return  employee;

    }

    public  Employee findEmployeeByEmail(String email) throws SQLException
    {
        Connection connection = DBConnectionUtils.createConnection();
        Employee employee = new Employee();
             try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where email=?");
            // Parameters start with 1
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();
             if (rs.next()) {
                 employee.setId(rs.getInt("id"));
                 employee.setFirstName(rs.getString("firstName"));
                 employee.setSecondName(rs.getString("secondName"));
                 employee.setBirthday(rs.getDate("birthday"));
                 employee.setEmail(rs.getString("email"));
                 employee.setDepId(rs.getInt("depId"));
              }
        }finally {
            connection.close();
        }
        return employee;
    }



}
