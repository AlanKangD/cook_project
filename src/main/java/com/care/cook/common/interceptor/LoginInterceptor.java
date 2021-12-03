package com.care.cook.common.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("로그인 인터셉터 동작 확인 ");
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") == null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script> alert('로그인 하세요'); location.href='/cook/index'; </script>");
			if(session.getAttribute("loginAdmin") != null) {
				return true;
			}
			return false;
		} 

		return true;
	}

}
