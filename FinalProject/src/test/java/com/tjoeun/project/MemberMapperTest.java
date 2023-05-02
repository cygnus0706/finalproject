package com.tjoeun.project;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tjoeun.project.mapper.MemberMapper;
import com.tjoeun.project.memberVO.MemberVO;

@SpringBootTest
public class MemberMapperTest {

	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	void insertMember() {
		
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
		
        
        memberMapper.insertMember(memberVO);
        
        
        // MemberVO selectedMember = memberMapper.hasMember(memberVO.getId());

        // assertThat =  JUnit 
//        assertThat(selectedMember.getId()).isEqualTo("testId");
//        assertThat(selectedMember.getPw()).isEqualTo("testPw");
//        assertThat(selectedMember.getName()).isEqualTo("testName");
//        assertThat(selectedMember.getGender()).isEqualTo("testGender");
//        assertThat(selectedMember.getMobile()).isEqualTo("010-1234-5678");
//        assertThat(selectedMember.getAddress1()).isEqualTo("testAddress1");
//        assertThat(selectedMember.getAddress2()).isEqualTo("testAddress2");
//        assertThat(selectedMember.getEmail()).isEqualTo("testEmail@test.com");
//        assertThat(selectedMember.getBirthday()).isEqualTo(Date.valueOf("1990-01-01"));
//        assertThat(selectedMember.getJoindate()).isToday();
    }
    
        
        
		
		
	
	
	
}
