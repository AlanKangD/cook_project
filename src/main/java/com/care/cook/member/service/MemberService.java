package com.care.cook.member.service;

import org.springframework.ui.Model;
import java.util.ArrayList;
import com.care.cook.member.dto.MemberDTO;


public interface MemberService {
	public int register(MemberDTO dto);
	public void loginChk(String id, String password);
	public void memberAllList(Model model);

}