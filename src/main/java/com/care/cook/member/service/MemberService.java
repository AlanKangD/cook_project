package com.care.cook.member.service;

import com.care.cook.member.dto.MemberDTO;

public interface MemberService {
	public void register(MemberDTO dto);
	public void loginChk(String id, String password);
}
