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
        String SQL = "insert into department (name) values (?)";

        try (Connection con = DBConnectionUtils.createConnection()){


            try (PreparedStatement statement = con != null ? con.prepareStatement(SQL) : null){
                log.trace("Create prepared statement");
                statement.setString(1,model.getName());
                statement.executeUpdate();
            }catch (SQLException e){
                log.error("Statement ADD COMMAND exception",e);
            }catch (NullPointerException e){
                log.error("CON is null",e);
            }

        } catch (SQLException e) {
            log.error("Connect exception in ADD COMMAND", e);
        }

    }




}
