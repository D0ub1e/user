package com.hkwy.dao;

import com.hkwy.model.User;
import com.hkwy.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by double on 16-12-14.
 */
public class UserDao {
    public  void add(User user){
        Connection con =null;
        PreparedStatement ps  =null;
        ResultSet rs =null;
        String sql ="insert into t_user values(null,?,?,?)";
        String sqlCount= "select conut(*) from t_user where username=?";
        con = DBUtil.getConnection();




    }
}
