package com.hkwy.dao;

import com.hkwy.model.User;

import java.util.List;

/**
 * Created by double on 16-12-14.
 */
public interface IUserDao {
    public void add(User user);
    public void  delete(int id);
    public void update(User user);
    public User load (int id);
    public List<User>list();
}
