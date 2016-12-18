package com.hkwy.service;

import com.hkwy.model.Page;
import com.hkwy.model.User;

import java.util.List;

/**
 * Created by double2 on 2016/12/14.
 */
public interface IUserserver {
    public  void add (User user);
    public  void delete (int id);
    public  void update (User user);
    public  User load( int id);
    public  List<User> list();
    public  User login(String username,String password);
    public  void updateStatus(int id);
    public Page<User> pages();

}
