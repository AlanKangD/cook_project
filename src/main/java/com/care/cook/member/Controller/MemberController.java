package com.care.cook.member.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.cook.member.dto.MemberDTO;
import com.care.cook.member.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired MemberService ms;
	
	@GetMapping("registerForm")
	public String registerForm() {return "/member/createForm";}
	
	@PostMapping("register")
	public String register(MemberDTO dto) {
		ms.register(dto);
		return "member/login";
	}
	
	@PostMapping("login")
	public String login(@RequestParam String id, @RequestParam String password) {
		ms.loginChk(id, password);
		return "member/loginSuccess";
	}
	
	
}
