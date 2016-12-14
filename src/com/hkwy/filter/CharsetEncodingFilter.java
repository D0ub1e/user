package com.hkwy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by double on 16-12-14.
 */
@WebFilter(filterName = "CharsetEncodingFilter")
public class CharsetEncodingFilter implements Filter {
    private  static  String charset;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        req.setCharacterEncoding(charset);
        chain.doFilter(req,resp);
    }

    public void init(FilterConfig config) throws ServletException {
        charset = config.getInitParameter("charset");
        if (charset == null || charset.equals(" ")){
            charset="UTF-8";
        }

    }

}
