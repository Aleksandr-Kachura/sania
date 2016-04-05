package com.test.servlet.dao.impl;

import com.test.servlet.dao.DepartmentDao;
import com.test.servlet.model.Department;
import com.test.servlet.util.DBConnectionUtils;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 04.04.16.
 */
public class DepartmentDaoImpl implements DepartmentDao{
    private static Logger log = Logger.getLogger(DepartmentDaoImpl.class);

    public List<Department> findAll() {
        Connection connection = DBConnectionUtils.createConnection();

        return null;
    }

    public void add(Department model) {
        Connection connection = DBConnectionUtils.createConnection();
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
