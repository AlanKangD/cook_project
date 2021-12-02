package com.care.cook.member.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.cook.member.dto.MemberDTO;


public interface MemberService {
	public int register(MemberDTO dto); // 회원가입 기능 
	public int loginChk(String id, String password); // 로그인 아이디, 비밀번호 확인 기능 
	public void memberAllList(Model model); // 모든 멤버 보기 기능 
	public void contentView(String id, Model model); // 특정 멤버 보기
	public void modifyMem(MemberDTO dto, HttpServletResponse response); // 멤버 정보 수정하기
	public void deleteMem(String id); // 멤버 삭제 
}