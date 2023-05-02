package com.tjoeun.project.memberVO;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name="member_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class MemberVO {
	
	// Oracle11g 에서는 strategy = GenerationType.IDENTITY 를 사용할수없다.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	@NonNull
	private String pw;
	
	private String name;
	
	private char gender;

	@NonNull
	private String email;
	
	//  "010-1234-5678"의 경우, "01012345678"과 같이 "-"를 제외한 숫자만 추출해서 int로 저장할 수 있습니다. 
	//  하지만 이 방법은 번거로울 뿐 아니라, 전화번호의 형식이 바뀔 경우에도 코드를 수정해야 하는 번거로움이 있습니다. 
	//  따라서, String으로 유지하는 것이 좋습니다.
	@NonNull
	private String mobile;
	
	private String address1;
	
	private String address2;
	
	private Date birthday;
	
	private Date joindate;

	// javateacher
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVO other = (MemberVO) obj;
		return Objects.equals(address1, other.address1) && Objects.equals(address2, other.address2)
				&& Objects.equals(birthday, other.birthday) && Objects.equals(email, other.email)
				&& gender == other.gender && Objects.equals(id, other.id) && Objects.equals(joindate, other.joindate)
				&& Objects.equals(mobile, other.mobile) && Objects.equals(name, other.name)
				&& Objects.equals(pw, other.pw);
	}

	@Override
	public int hashCode() {
		return Objects.hash(address1, address2, birthday, email, gender, id, joindate, mobile, name, pw);
	}
	
}