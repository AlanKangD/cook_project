package com.care.cook.common.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.care.cook.common.session.SessionName;

public class MemberListInterceptor extends HandlerInterceptorAdapter implements SessionName {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("회원목록 인터셉터 동작 확인(관리자만 접근가능) ");
		HttpSession session = request.getSession();
		if(session.getAttribute(SessionName.ADMINSESSION) == null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script> alert('관리자만 접근 가능.추후 헤더 수정 예정'); location.href='/cook/index'; </script>");
			return false;
		}
		return true;
	}

}