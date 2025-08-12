package com.example.jv250211_md04_session05.models.until;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mvc_student";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456789n";

    public static Connection openConnection(){
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn , CallableStatement callstm){
        if(conn!= null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(callstm != null) {
            try {
                callstm.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
