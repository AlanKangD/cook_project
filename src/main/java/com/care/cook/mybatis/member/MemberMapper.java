package com.care.cook.mybatis.member;

import java.util.ArrayList;

import com.care.cook.member.dto.MemberDTO;

public interface MemberMapper {
	public int register(MemberDTO dto);
	public ArrayList<MemberDTO> loginChk(String id);
}
