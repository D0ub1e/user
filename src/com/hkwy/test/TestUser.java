package com.hkwy.test;

import com.hkwy.dao.IUserDao;
import com.hkwy.dao.impl.UserDao;
import com.hkwy.model.User;
import org.junit.Test;

/**
 * Created by double on 16-12-20.
 */
public class TestUser {
    static IUserDao userDao = new UserDao();
    @Test
    public  void testAdd(){
        User user = new User("liubei","123456","刘备");
        try {
            userDao.add(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
