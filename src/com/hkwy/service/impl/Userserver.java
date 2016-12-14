package com.hkwy.service.impl;

import com.hkwy.dao.IUserDao;
import com.hkwy.dao.impl.UserDao;
import com.hkwy.model.User;
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

}
