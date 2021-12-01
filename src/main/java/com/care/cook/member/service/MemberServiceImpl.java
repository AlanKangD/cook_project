package com.care.cook.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.cook.member.dto.MemberDTO;
import com.care.cook.mybatis.member.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired MemberMapper mapper;

	@Override
	public void memberAllList(Model model) {
		
		model.addAttribute("memberAllList", mapper.memberAllList());
	}

}
