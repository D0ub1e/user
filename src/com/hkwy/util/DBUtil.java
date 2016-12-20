package com.hkwy.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by double on 16-12-14.
 */
public class DBUtil {
    //加载数据库的驱动
    private static String driverName;
    private static String url;
    private static String username;
    private static String password;
    static {
        Properties properties = new Properties();
        InputStream inputStream = Thread.currentThread()
                .getContextClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(inputStream);
            driverName = properties.getProperty("driverName");
            url= properties.getProperty("url");
            username=properties.getProperty("username");
            password=properties.getProperty("password");
            Class.forName(driverName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }


    public  static  void  close(Connection con){
        if (con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public  static  void close(PreparedStatement ps){
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public  static  void close(ResultSet rs){
        if (rs !=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
