package com.hkwy.dao;

import com.hkwy.model.User;

import java.util.List;

/**
 * Created by double on 16-12-14.
 */
public interface IUserDao {
    public void add(User user);
    public void delete(int id);
    public void update(User user);
    public User load(int id);
    public List<User> list();
    public  User login(String usernmae);
    public void updatestatus(User user);
    //要实现这种方法必须在先有Page模型 然后在进行数据的操作
    public Page<User> pages();
}
