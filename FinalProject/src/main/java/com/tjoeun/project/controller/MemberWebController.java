package com.tjoeun.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tjoeun.project.memberService.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class MemberWebController {
	
	
	private MemberService memberService;
	

	@GetMapping(value="/")
	public String mainPage() throws Exception {
		
		log.info("view error : ");
		return "/view/main.html";
	}

	   @GetMapping("/view/main")
	    public String main(Model model, HttpSession session) {
	        // session에서 필요한 정보를 가져와서 model에 추가하는 로직 추가
	        return "/view/main.html";
	    }
	
	   @PostMapping("/login")
	   public String login(HttpServletRequest request, RedirectAttributes rttr, @RequestParam("id") String id, @RequestParam("pw") String pw) {
	       HttpSession session = request.getSession();
	       boolean result = memberService.login(id, pw);
	       if(result) {
	           session.setAttribute("sess", id);
	           session.setAttribute("sess", memberService.getMember(id).getName());
	           return "redirect:/view/main.html";
	       } else {
	           rttr.addFlashAttribute("msg", "아이디 또는 비밀번호를 확인해주세요.");
	           return "redirect:/view/main.html";
	       }
	   }
	
}
