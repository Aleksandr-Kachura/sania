package com.test.servlet.dao.impl.jdbc;

import com.test.servlet.dao.DepartmentDao;
import com.test.servlet.model.Department;
import com.test.servlet.util.DBConnectionUtils;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 04.04.16.
 */
public class DepartmentDaoImpl implements DepartmentDao{



    private static Logger log = Logger.getLogger(DepartmentDaoImpl.class);

    public List<Department> findAll() throws SQLException {
        Connection connection = DBConnectionUtils.createConnection();
        List<Department> departments = new ArrayList<Department>();
        try {
            String SQL = "select * from department";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next())
            {
                Department dep = new Department();
                dep.setId(rs.getInt("id"));
                dep.setName(rs.getString("name"));
                departments.add(dep);
            }
        }finally {
            connection.close();
        }
        return departments;
    }

    public Department findDepartmentById(int id) throws SQLException
    {
        Connection connection = DBConnectionUtils.createConnection();
        Department department = new Department();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from department where id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
            }

        }finally {
            connection.close();
        }
        return  department;

    }

    public Department findDepartmentByName(String name) throws SQLException
    {
        Connection connection = DBConnectionUtils.createConnection();
        Department department = new Department();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from department where name=?");
            // Parameters start with 1
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
            }

        }finally {
            connection.close();
        }
        return  department;

    }


    public void delete(Department model) throws SQLException
    {
        Connection connection = DBConnectionUtils.createConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from department where id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, model.getId());
            preparedStatement.executeUpdate();

        } finally {
            connection.close();
        }
    }



    public void add(Department model) throws SQLException {

        Connection connection = DBConnectionUtils.createConnection();
        try {
            String SQL = "insert into department (name) values (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, model.getName());
            preparedStatement.executeUpdate();
        }finally {
            connection.close();
        }

    }

    public void update(Department model) throws SQLException {

        Connection connection = DBConnectionUtils.createConnection();
        try {
            String SQL = "update department SET name = ? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, model.getName());
            preparedStatement.setInt(2, model.getId());
            preparedStatement.executeUpdate();

        }finally {
            connection.close();
        }

    }

   public void saveOrUpdate(Department model) throws SQLException
    {
        Connection connection = DBConnectionUtils.createConnection();
        try {
           String SQL = "update department SET name2 = ? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, model.getName());
            preparedStatement.setInt(2, model.getId());
            preparedStatement.executeUpdate();
        }finally {
            connection.close();
        }

    }




}
