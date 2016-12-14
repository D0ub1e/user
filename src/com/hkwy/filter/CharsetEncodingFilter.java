package com.hkwy.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by double2 on 2016/12/14.
 */
public class CharsetEncodingFilter implements Filter {
    private  static String charset;
    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding(charset);
        chain.doFilter(req,resp);

    }

    public void init(FilterConfig config) throws ServletException {
        charset =config.getInitParameter("charset");
        if(charset == null||charset.equals(" ")) {
            charset = "UTF-8";
        }

    }

}
