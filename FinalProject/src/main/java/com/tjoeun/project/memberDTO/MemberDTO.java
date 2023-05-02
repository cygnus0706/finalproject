package com.tjoeun.project.memberDTO;

import java.sql.Date;

import com.tjoeun.project.memberVO.MemberVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDTO {

	
	
	private String id;
	
	private String pw;
	
	private String name;
	
	private char gender;

	private String email;

	private String mobile;
	
	private String address1;
	
	private String address2;
	
	private Date birthday;
	
	private Date joindate;

	
	public MemberDTO (final MemberVO memberVO) {
		
		this.id = memberVO.getId();
		this.pw = memberVO.getPw();
		this.name = memberVO.getName();
		this.gender = memberVO.getGender();
		this.email = memberVO.getEmail();
		this.mobile = memberVO.getMobile();
		this.address1 = memberVO.getAddress1();
		this.address2 = memberVO.getAddress2();
		this.birthday = memberVO.getBirthday();
		this.joindate = memberVO.getJoindate();
		
	}
	
	
	public static MemberVO toMemberVO(final MemberDTO memberDTO) {
		
		
		return toMemberVO(memberDTO);
	}
	
	
}
