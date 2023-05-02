package com.tjoeun.project;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tjoeun.project.mapper.MemberMapper;
import com.tjoeun.project.memberVO.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class MemberMapperJavateacherTest {

	// case-1
	@Autowired
	private MemberMapper memberMapper;
	
	// case-2
	@Autowired
	SqlSession sqlSession;
	
	MemberVO originalMemberVO;
	
	@BeforeEach
	public void setUp() {
		
		originalMemberVO = new MemberVO();
		originalMemberVO.setId("testId");
        originalMemberVO.setPw("testPw");
        originalMemberVO.setName("testName");
        originalMemberVO.setGender('1');
        originalMemberVO.setMobile("01012345678");
        originalMemberVO.setAddress1("testAddress1");
        originalMemberVO.setAddress2("testAddress2");
        originalMemberVO.setEmail("testEmail@test.com");
        originalMemberVO.setBirthday(Date.valueOf("1990-01-01"));
        originalMemberVO.setJoindate(Date.valueOf("2023-04-26"));
	}
	
	@Test
	void selectMemberTest() {
		
		// case-1
		// MemberVO memberVO = memberMapper.hasMember("testId"); // (X)
		MemberVO memberVO = memberMapper.getMember("testId");
		
		// case-2
		// MemberVO memberVO = sqlSession.getMapper(MemberMapper.class).hasMember("testId"); // (X)
		// MemberVO memberVO = sqlSession.getMapper(MemberMapper.class).getMember("testId"); 
		
        // log.info("memberMapper : " + sqlSession.getMapper(MemberMapper.class).hasMember("testId"));
		
		log.info("originalMemberVO : " + originalMemberVO);
		log.info("memberVO : " + memberVO);
		
		assertThat(originalMemberVO.equals(memberVO));
		
    }
    	
}