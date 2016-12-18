package com.hkwy.filter;

import com.hkwy.model.SystemContext;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by double2 on 2016/12/18.
 */
public class SystemContextFilter implements Filter {
    public static int pageSize;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        int pageIndex;
        try {
            pageIndex = Integer.parseInt(req.getParameter("pageIndex"));

        }catch (NumberFormatException e){
            pageIndex =1;
        }
        try{
            SystemContext.setPageSize(pageSize);
            SystemContext.setPageIndex(pageIndex);
            chain.doFilter(req,resp);
        }finally {
            SystemContext.removePageIndex();
            SystemContext.removePageSize();
        }
    }


    public void init(FilterConfig config) throws ServletException {

        try {
            pageSize = Integer.parseInt(config.getInitParameter("pageSize"));
        } catch (NumberFormatException e) {
            pageSize = 5;
            e.printStackTrace();
        }


    }

}
