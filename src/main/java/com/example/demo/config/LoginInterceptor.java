/**
 * Project name: SpringBase
 * Package name: com.example.demo.config
 * File name: LoginInterceptor.java
 * Author: ptphuong.
 * Created date: Jan 18, 2019
 * Created time: 7:34:49 PM
 */

package com.example.demo.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.demo.entities.User;

/*
 * @author ptphuong.
 * Created date: Jan 18, 2019
 * Created time: 7:34:49 PM
 * Description: TODO - 
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(
     * javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, java.lang.Object) Author: ptphuong.
     * Created date: Jan 18, 2019 Created time: 7:35:21 PM
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	    throws Exception {
	System.out.println("Request URL :: " + request.getRequestURL());

	String url = request.getRequestURI();
	if (url.equals("/login")) {
	    return true;
	} else {
	    User user = (User) request.getSession().getAttribute("user");
	    if (user == null) {
		response.sendRedirect("/");
		return false;
	    }
	    if (user.getEmail() != null && user.getEmail().equals("abc"))
		return true;
	}

	return super.preHandle(request, response, handler);
    }

}
