package com.hkwy.dao.impl;

import com.hkwy.dao.IUserDao;
import com.hkwy.model.Page;
import com.hkwy.model.SystemContext;
import com.hkwy.model.User;
import com.hkwy.model.UserException;
import com.hkwy.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by double on 16-12-14.
 */
public class UserDao implements IUserDao {
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

    public void delete(int id){
        Connection con =null;
        PreparedStatement ps  =null;
        String sql = "delete from t_user where id=?";
        try {
              con = DBUtil.getConnection();
            ps =con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(ps);
            DBUtil.close(con);
        }
    }

    @Override
    public void update(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "update t_user set password=?,nickname=? where id=?";
        try {
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getNickname());
            ps.setInt(3, user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtil.close(ps);
            DBUtil.close(con);
        }
    }

    public  User load (int id){
       Connection connection = null;
       PreparedStatement preparedStatement =null;
       String sql = "select * from t_user where id =?";
       User user = null;
       ResultSet rs =null;

       try {
           connection =DBUtil.getConnection();
           preparedStatement=connection.prepareStatement(sql);
           preparedStatement.setInt(1,id);
           rs =preparedStatement.executeQuery();
           while (rs.next()){
               user = new User();
               user.setId(rs.getInt("id"));
               user.setUsername(rs.getString("username"));
               user.setPassword(rs.getString("password"));
               user.setNickname(rs.getString("nickname"));
           }

       } catch (Exception e) {
           e.printStackTrace();
       }finally {
           DBUtil.close(rs);
           DBUtil.close(preparedStatement);
           DBUtil.close(connection);
       }
        return user;
   }

   public List<User> list(){
       Connection connection = null;
       PreparedStatement ps = null;
        ResultSet resultSet =null;
       String sql = "select * form t_user";
       List<User> users = new ArrayList<User>();
       User user  = null;
       try {
           connection = DBUtil.getConnection();
           ps =connection.prepareStatement(sql);
           resultSet =ps.executeQuery();
           while (resultSet.next()){
               user = new User();
               user.setId(resultSet.getInt("id"));
               user.setNickname(resultSet.getString("nickname"));
               user.setPassword(resultSet.getString("password"));
               user.setUsername(resultSet.getString("username"));
               users.add(user);


           }
       } catch (Exception e) {
           e.printStackTrace();
       }finally {
           DBUtil.close(resultSet);
           DBUtil.close(ps);
           DBUtil.close(connection);
       }
       return  users;
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

    @Override
    public Page<User> pages() {
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet =null;
        String sql = "select * from t_user limit ?,?";
        String sqlCount = "select count(*) from t_user";
        List<User> users = new ArrayList<User>();
        Page<User> pages = new Page<User>();
        User user = null;
        int pageIndex = SystemContext.getPageIndex();
        int pageSize = SystemContext.getPageSize();
        int start =(pageIndex - 1) *pageSize;
        int totalRecord = 0;
        try {
            connection = DBUtil.getConnection();
            preparedStatement =connection.prepareStatement(sqlCount);
            resultSet =preparedStatement.executeQuery();
            while (resultSet.next()){
                totalRecord = resultSet.getInt(1);

            }
            //两次使用的ps这个参数 是因为事先声明了好了 preparedStateme =null；
            preparedStatement  = connection.prepareStatement(sql);
            //这有一定的问题啊！
            preparedStatement.setInt(start, 1);
            preparedStatement.setInt(pageSize,2);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user  = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setNickname(resultSet.getString("nickname"));
                user.setRole(resultSet.getInt("role"));
                user.setStatus(resultSet.getInt("status"));
                users.add(user);

            }



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(resultSet);
            DBUtil.close(preparedStatement);
            DBUtil.close(connection);
        }
        int totalPage =(totalRecord -1)/pageSize+1;
        pages.setPageSize(pageSize);
        pages.setPageIndex(pageIndex);
        pages.setTotalPage(totalPage);
        pages.setTotalRecord(totalRecord);
        pages.setDatas(users);
        return pages;
    }

}
