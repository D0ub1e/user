package com.hkwy.servlet;

import com.hkwy.model.User;
import com.hkwy.service.IUserserver;
import com.hkwy.service.impl.Userserver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by double2 on 2016/12/14.
 */
public class UserServlet extends HttpServlet {
    IUserserver userServer = new Userserver();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if(method.equals("list")) {
            this.list(req, resp);
        }
        else if(method.equals("addInput")) {
            this.addInput(req, resp);
        }
        else if(method.equals("add")) {
            this.add(req, resp);
        }
        else if(method.equals("updateInput")) {
            this.updateInput(req, resp);
        }
        else if(method.equals("update")) {
            this.update(req, resp);
        }

        else if(method.equals("delete")) {
            this.delete(req, resp);
        }
    }

    public void addInput(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/user/add.jsp").forward(req, resp);
    }

    public void add(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");
        User user = new User(username, password, nickname);
        userServer.add(user);
        this.list(req, resp);
    }

    public void updateInput(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = userServer.load(id);
        req.setAttribute("user", user);
        req.getRequestDispatcher("WEB-INF/jsp/user/update.jsp").forward(req, resp);
    }

    public void update(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");
        User user = new User();
        user.setId(id);
        user.setNickname(nickname);
        user.setPassword(password);
        userServer.update(user);
        this.list(req, resp);
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        userServer.delete(id);
        this.list(req, resp);
    }

    public void list(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<User> users = userServer.list();
        req.setAttribute("users", users);
        req.getRequestDispatcher("WEB-INF/jsp/user/list.jsp").forward(req, resp);
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req,resp);

    }
}
