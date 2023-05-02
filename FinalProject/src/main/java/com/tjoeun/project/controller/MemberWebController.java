package com.tjoeun.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class MemberWebController {

	@GetMapping(value="/")
	public String mainPage() throws Exception {
		
		log.info("view error : ");
		return "/view/main.html";
	}
	
//	@GetMapping(value = "/main")
//	public String main() {
//		
//		log.info("view error : ");
//		return "/view/main.html";
//	}
	
	
	
}
