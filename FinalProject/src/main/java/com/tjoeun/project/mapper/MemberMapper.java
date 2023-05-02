package com.tjoeun.project.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tjoeun.project.memberVO.MemberVO;

@Mapper
public interface MemberMapper {


	// @Insert("INSERT INTO member_tbl (id, pw, name, gender, email, mobile, address1, address2,  birthday, joindate)"
	//		+ "VALUES (#{id}, #{pw}, #{name}, #{gender}, #{email}, #{mobile}, #{address}, #{birthday}, #{joindate})")

	// javateacher
	// #{address} ==> #{address1}, #{address2}
	@Insert("INSERT INTO member_tbl (id, pw, name, gender, email, mobile, address1, address2,  birthday, joindate)"
			+ "VALUES (#{id}, #{pw}, #{name}, #{gender}, #{email}, #{mobile}, #{address1}, #{address2}, #{birthday}, #{joindate})")
	public void insertMember(MemberVO memberVO);

	
	
	@Update("UPDATE member_tbl SET pw=#{pw}, name=#{name}, mobile=#{mobile}, "
			+ "address1=#{address1}, address2=#{address2}, email=#{email}, birthday=#{birthday} WHERE id=#{id}")
	public void updateMember(MemberVO memberVO);
	
	
	
	@Delete("DELETE FROM member_tbl WHERE id=#{id}")
	public void deleteMember(MemberVO memberVO);
	
	
	
	// @Select("SELECT COUNT(*) FROM member_tbl WHERE id=#{id}")
	// public MemberVO hasMember(String id);
	@Select("SELECT case when count(*) = 1 then 'true' " +
		    "   		else 'false' " +
		    "   	end as result " +
		    "FROM member_tbl WHERE id=#{id}")
	public boolean hasMember(String id);
	
	// javateacher
	@Select("SELECT * FROM member_tbl WHERE id=#{id}")
	public MemberVO getMember(String id);
}
