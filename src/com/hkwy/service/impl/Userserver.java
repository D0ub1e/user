package com.hkwy.service.impl;

import com.hkwy.dao.IUserDao;
import com.hkwy.dao.impl.UserDao;
import com.hkwy.model.Page;
import com.hkwy.model.User;
import com.hkwy.model.UserException;
import com.hkwy.service.IUserserver;
import com.obj.test.CodeUtil;

import java.util.List;

public class Userserver implements IUserserver {
    private IUserDao userDao = new UserDao();

    public void add(User user) {
        // TODO Auto-generated method stub
        String password = user.getPassword();
        String newPassword = CodeUtil.encrypt(password);
        user.setPassword(newPassword);
        userDao.add(user);
    }

    public void delete(int id) {
        // TODO Auto-generated method stub
        userDao.delete(id);
    }

    public void update(User user) {
        // TODO Auto-generated method stub
        String password = user.getPassword();
        String newPassword = CodeUtil.encrypt(password);
        user.setPassword(newPassword);
        userDao.update(user);
    }

    public User load(int id) {
        // TODO Auto-generated method stub
        return userDao.load(id);
    }

    public List<User> list() {
        // TODO Auto-generated method stub
        return userDao.list();
    }

    @Override
    public User login(String username, String password) {
        User user = userDao.login(username);
        if (user == null){
            throw new UserException("用户登录");
        }
        String newpassword = CodeUtil.decrypt(user.getPassword());
        if (!newpassword.equals(password)){
            throw  new UserException("您的密码不正确");

        }if (user.getStatus()==2){
            throw  new  UserException("您的登录账号不能登录");
        }


        return user;
    }

    @Override
    public void updateStatus(int id) {
        User user =this.load(id);
        if (user.getStatus() ==1){
            user.setStatus(2);
        }else if (user.getStatus()==2){
            user.setStatus(1);
        }
        userDao.updatestatus(user);
    }

    @Override
    public Page<User> pages() {
        return userDao.pages();
    }

}
