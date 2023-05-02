package com.tjoeun.project;

import java.sql.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.tjoeun.project.mapper.MemberMapper;
import com.tjoeun.project.memberVO.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class InsertMemberMapperJavateacherTest2 {

	// case-1
	// @Autowired
	// SqlSession sqlSession;
	
	// case-2
	@Autowired
	MemberMapper memberMapper;
	
	@Test
	@Transactional
	@Rollback(false)
	void insertMemberTest() {
		
		MemberVO memberVO = new MemberVO();
		
		memberVO.setId("testId");
        memberVO.setPw("testPw");
        memberVO.setName("testName");
        memberVO.setGender('1');
        memberVO.setMobile("01012345678");
        memberVO.setAddress1("testAddress1");
        memberVO.setAddress2("testAddress2");
        memberVO.setEmail("testEmail@test.com");
        memberVO.setBirthday(Date.valueOf("1990-01-01"));
        memberVO.setJoindate(Date.valueOf("2023-04-26"));
        
        log.info("memberVO : " + memberVO);
		
        // case-1
        // sqlSession.getMapper(MemberMapper.class).insertMember(memberVO);
        
        // case-2
        memberMapper.insertMember(memberVO);
        
        // javateacher
        // 에러 메시지 : 
        // Caused by: org.apache.ibatis.reflection.ReflectionException: 
        // There is no getter for property named 'address' in 'class com.tjoeun.project.memberVO.MemberVO'
        
        
    }

}