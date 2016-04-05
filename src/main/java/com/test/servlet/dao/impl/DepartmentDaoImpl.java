package com.test.servlet.dao.impl;

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

    private Connection connection;

    public DepartmentDaoImpl(){
        connection = DBConnectionUtils.createConnection();
    }

    private static Logger log = Logger.getLogger(DepartmentDaoImpl.class);

    public List<Department> findAll() {
        List<Department> departments = new ArrayList<Department>();
        try {
            String SQL = "select * from department";
            Statement statement = connection.createStatement();

            //TODO почитать
            ResultSet rs = statement.executeQuery(SQL);
            while (rs.next())
            {
                Department dep = new Department();
                dep.setId(rs.getInt("id"));
                dep.setName(rs.getString("name"));
                departments.add(dep);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }


        return departments;
    }

  /*  public User getUserById(int userId) {
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from users where userid=?");
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                user.setUserid(rs.getInt("userid"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setDob(rs.getDate("dob"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }*/

    public Department findDepartmentById(int id)
    {
        Department department = new Department();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from department where id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  department;

    }


    public void delete(Department model)
    {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from department where id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, model.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void add(Department model) {
        try {
            String SQL = "insert into department (name) values (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, model.getName());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }




}
