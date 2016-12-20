package com.hkwy.dao.impl;

import com.hkwy.dao.IUserDao;
import com.hkwy.model.User;
import com.hkwy.model.UserException;
import com.hkwy.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by double on 16-12-14.
 */
public class UserDao extends BaseDao<User> implements IUserDao {
    public  void add(User user){
        Connection con =null;
        PreparedStatement ps  =null;
        ResultSet rs =null;
        String sql ="insert into t_user values(null,?,?,?)";
        String sqlCount= "select conut(*) from t_user where username=?";
        try {
            con = DBUtil.getConnection();
            ps =con.prepareStatement(sqlCount);
            ps.setString(1,user.getUsername());
            rs = ps.executeQuery();
            while (rs.next()){
                if(rs.getInt(1)>0){
                    throw  new UserException("用户已经存在");
                }
            }
            ps = con.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getNickname());
            ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
            DBUtil.close(con);
        }


    }

    @Override
    public User login(String username) {
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet =null;
        String sql = "select * from t_user where username =?";
        User user =null;
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setNickname(resultSet.getString("nickname"));
                user.setRole(resultSet.getInt("role"));
                user.setStatus(resultSet.getInt("status"));

            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(resultSet);
            DBUtil.close(preparedStatement);
            DBUtil.close(connection);
        }
        return user;
    }

    @Override
    public void updatestatus(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        String sql = "update t_user set status=? where id= ?";
        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,user.getStatus());
            preparedStatement.setInt(2,user.getRole());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(preparedStatement);
            DBUtil.close(connection);
        }
    }


}
