package com.tjoeun.project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.tjoeun.project.memberDTO.MemberDTO;
import com.tjoeun.project.memberService.MemberService;
import com.tjoeun.project.memberVO.MemberVO;

import jakarta.servlet.http.HttpServletRequest;


public class MemberController {

	@Autowired
	private MemberService memberService;
	
	
	// 회원등록  (회원정보 수정에도 사용할수있을꺼같다)  CRUD Create Update
	@PostMapping("/")
	public ResponseEntity<MemberVO> insertMember(@RequestBody MemberVO memberVO){
		
		return ResponseEntity.ok(memberService.insertMember(memberVO));
	}

	// Read  .. Retrieve
	@GetMapping("/id")
	public ResponseEntity<MemberVO> hasMember(@PathVariable("id") String id) {
		
		Optional<MemberVO> optionalMemberVO = memberService.hasMember(id);
		
		return optionalMemberVO.map(memberVO -> ResponseEntity.ok().body(memberVO))
							   .orElseGet(() -> ResponseEntity.notFound().build());
		
	}
	
	
//	 @PostMapping("/")
//	  public ResponseEntity<MemberDTO> insertMember(@RequestBody MemberDTO memberDTO) {
//	    MemberVO memberVO = MemberDTO.toMemberVO(memberDTO);
//	    MemberVO insertedMember = memberService.insertMember(memberVO);
//	    MemberDTO insertedMemberDTO = new MemberDTO(insertedMember);
//	    return new ResponseEntity<>(insertedMemberDTO, HttpStatus.CREATED);
//	  }
	
	
}