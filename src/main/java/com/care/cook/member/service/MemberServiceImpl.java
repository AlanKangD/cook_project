package com.care.cook.member.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.cook.member.dto.MemberDTO;
import com.care.cook.mybatis.member.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberMapper mapper;
	
	BCryptPasswordEncoder encoder; //비밀번호 암호화 해주는 객체
	
	public MemberServiceImpl() {
		encoder = new BCryptPasswordEncoder();
	}
	
	@Override
	public int register(MemberDTO dto) {
		int result = 0;
		String securePw = encoder.encode(dto.getPassword());
		dto.setPassword(securePw);
		try {
			result = mapper.register(dto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return result;
	}

	@Override
	public int loginChk(String id, String password) {
		MemberDTO dto = mapper.loginChk(id);
		int result = 0;
		if(dto == null) {
			System.out.println("없는 아이디 ");
//		} else if(encoder.matches(password, dto.getPassword())) {   //암호화 되어있는 비밀번호 확인 시 
		} else if(password.equals(dto.getPassword())) {
			System.out.println("로그인 성공");
			result = 1;
		} else {
			System.out.println("비번 틀림");
		}
		return result;
	}
		
	@Override
	public void memberAllList(Model model) {
		
		model.addAttribute("memberAllList", mapper.memberAllList());

	}

	@Override
	public void contentView(String id, Model model) {
		model.addAttribute("dto", mapper.contentView(id));	
	}

	@Override
	public void modifyMem(MemberDTO dto, HttpServletResponse response) {		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int result = mapper.modifyMem(dto);
		if(result == 1) {
			out.print("<script>alert('수정에 성공하였습니다');"
					+ "location.href='memberInfo';</script>");
		} else {
			out.print("<script>alert('수정 실패');"
					+ "location.href='memberInfo';</script>");
		}
	}

	@Override
	public void deleteMem(String id) {
		mapper.deleteMem(id);
	}
	


}
