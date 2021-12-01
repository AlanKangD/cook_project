package com.care.cook.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
	public void loginChk(String id, String password) {
		ArrayList<MemberDTO> dto = mapper.loginChk(id);
		if(dto.isEmpty()) {
			System.out.println("없는 아이디 ");
		} else if(encoder.matches(password, dto.get(0).getPassword())) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("비번 틀림");
		}
	}
		
	@Override
	public void memberAllList(Model model) {
		
		model.addAttribute("memberAllList", mapper.memberAllList());

	}

}
