package com.test.servlet.util;


import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created on 04.04.16.
 */
public class DBConnectionUtils {

    private static final Logger log = Logger.getLogger(DBConnectionUtils.class);

    static final String DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost:3306/dao";
    static final String LOGIN = "root";
    static final String PASS = "1";

  /*  public static Connection createConnection(){
        try {
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            log.error("DRIVER problem", e);
            return null;
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL,LOGIN,PASS);
            return connection;
        }catch (SQLException e){
            log.error("Connection problem in FcactoryDAO",e);
            return null;
        }catch (NullPointerException e){
            log.error("Connection is NULL in DAO Factory",e);
            return null;
        }
    }*/

}
