package com.care.cook.mybatis.member;

import java.util.ArrayList;


import com.care.cook.member.dto.MemberDTO;

public interface MemberMapper {
	public int register(MemberDTO dto);
	public MemberDTO loginChk(String id);
	public ArrayList<MemberDTO> memberAllList();
	public MemberDTO contentView(String id);
	public int modifyMem(MemberDTO dto);
	public void deleteMem(String id);

}
