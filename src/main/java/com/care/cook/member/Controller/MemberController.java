package com.care.cook.member.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.care.cook.member.dto.MemberDTO;
import com.care.cook.member.service.MemberService;
import org.springframework.ui.Model;


@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired MemberService ms;
	
	@GetMapping("memberInfo")
	public String memberInfo(Model model) {
		ms.memberAllList(model);
		return "member/memberAllList";
	}
	
	@GetMapping("registerForm")
	public String registerForm() {
		
		return "/member/createForm";
	}
	
	@PostMapping("register")
	public String register(MemberDTO dto) {
		ms.register(dto);
		return "/default/main";
	}
	
	@PostMapping(value="login", produces = "application/json; charset=utf-8")
	@ResponseBody
//	public String login(@RequestBody String id, @RequestBody String password) {
	public String login(@RequestBody MemberDTO dto, HttpSession session) {		
		int result = ms.loginChk(dto.getId(), dto.getPassword());
		if(result == 1) {	
			session.setAttribute("loginUser", dto.getId());		
			 String id = dto.getId();
			return "{\"result\":\""+id+"\"}"; // {result : "id"}  result키 : 벨류
		}		
		return "{\"result\":false}";  // { result : false } 
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginUser");
		return "redirect: /cook/index";
	}
	
	@GetMapping("contentView")
	public String contentView(@RequestParam String id, Model model) {
		ms.contentView(id, model); 
		return "/member/contentView";
	}
	
	@PostMapping("modifyMem")
	public void modifyMem(MemberDTO dto, HttpServletResponse response) {		
		ms.modifyMem(dto, response);
	}
	@GetMapping("deleteMem")
	public String deleteMem(@RequestParam String id) {
		ms.deleteMem(id);
		return "redirect:/member/memberInfo";
	}
	
	
}
