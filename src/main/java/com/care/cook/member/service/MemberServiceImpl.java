package com.care.cook.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.care.cook.member.dto.MemberDTO;
import com.care.cook.mybatis.member.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired MemberMapper mm;
	
	@Override
	public void register(MemberDTO dto) {
		int result = mm.register(dto);
		if(result == 1) {
			System.out.println("저장 성공 ");
		}else {
			System.out.println("저장 실패");
		}
		
	}

	@Override
	public void loginChk(String id, String password) {
		ArrayList<MemberDTO> dto = mm.loginChk(id);
		if(dto.isEmpty()) {
			System.out.println("없는 아이디 ");
		} else if(password.equals(dto.get(0).getPassword())) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("비번 틀림");
		}
		
	}

}
