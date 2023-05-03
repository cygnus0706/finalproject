package com.tjoeun.project.memberService;

import java.util.Optional;

import org.apache.ibatis.javassist.compiler.ast.Member;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tjoeun.project.mapper.MemberMapper;
import com.tjoeun.project.memberVO.MemberRepository;
import com.tjoeun.project.memberVO.MemberVO;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;




@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class MemberService {

	@Autowired
	MemberMapper memberMapper;
	
	@Autowired
	private MemberRepository memberRepository;
	
	
	
	
	/**
	 * 회원가입
	 * 
	 * 
	 * @param memberVO
	 * @return
	 */
	public MemberVO insertMember(final MemberVO memberVO) {
	 
		
		
		
		return memberRepository.save(memberVO);
	}
		
		
		
		
		
	
	
	
	
	/**
	 * 회원정보수정
	 * 
	 * 
	 * @param memberVO
	 * @return
	 */
	@Transactional
	public MemberVO updateMember(MemberVO memberVO) {
		
	
		log.info("회원정보수정 : " + memberVO.getId());
		
		
		return memberRepository.save(memberVO);
		
		
	}
	
	
	
	/**
	 * 회원정보 삭제
	 * 
	 * 
	 * @param id
	 */
	
	public void deleteMember(String id) {

		
		log.info("회원정보 삭제 : "  );
		
		
		memberRepository.deleteById(id);
	}
	
	
	
	
	/**
	 * 회원정보 조회
	 * 
	 * 
	 * @param id
	 * @return
	 */
	public Optional<MemberVO> hasMember(String id){
		
		
		log.info("회원정보 검색 : ");
		
		
		return memberRepository.findById(id);
		
	}


	
	public boolean login(String id, String pw) {

		return memberRepository.findByIdAndPw(id, pw);
	}


	public MemberVO getMember(String id) {
	    return memberRepository.findById(id).orElse(null);
	}
	
}