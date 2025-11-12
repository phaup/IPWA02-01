package de.iubh.likeherotozero.util;

import de.iubh.likeherotozero.controller.SessionBean;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/admin/*")
public class SecurityFilter implements Filter {

    @Inject
    private SessionBean sessionBean;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
            throws IOException, ServletException {
        
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        if (sessionBean == null || !sessionBean.isLoggedIn()) {
            response.sendRedirect(request.getContextPath() + "/login.xhtml");
        } else {
            chain.doFilter(req, res);
        }
    }
}