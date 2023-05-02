package com.tjoeun.project;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
public class HasMemberMapperJavateacherTest {

	// case-1
	@Autowired
	private MemberMapper memberMapper;
	
	// case-2
	@Autowired
	SqlSession sqlSession;
	
	MemberVO originalMemberVO;
	
	
	@Test
	void hasMemberTest() {
		
		boolean isMember1 = memberMapper.hasMember("testId");
		boolean isMember2 = memberMapper.hasMember("testId2");
		
		log.info("isMember1 : " + isMember1);
		log.info("isMember2 : " + isMember2);
		
		assertTrue(isMember1);
		assertFalse(isMember2);
		
    }
    	
}