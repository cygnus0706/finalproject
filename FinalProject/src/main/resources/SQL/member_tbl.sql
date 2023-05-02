CREATE TABLE member_tbl (
id VARCHAR2(20),
pw VARCHAR2(20),
name VARCHAR2(100 char),
gender CHAR,
email VARCHAR2(50 char),
mobile VARCHAR2(13 char),
address1 VARCHAR2(300 char),
address2 VARCHAR2(300 char),
birthday DATE,
joindate DATE DEFAULT sysdate
);

COMMENT ON COLUMN member_tbl.id IS '아이디';
COMMENT ON COLUMN member_tbl.pw IS '패스워드';
COMMENT ON COLUMN member_tbl.name IS '이름';
COMMENT ON COLUMN member_tbl.gender IS '성별';
COMMENT ON COLUMN member_tbl.email IS '이메일';
COMMENT ON COLUMN member_tbl.mobile IS '연락처';
COMMENT ON COLUMN member_tbl.address1 IS '기본주소(도로명)';
COMMENT ON COLUMN member_tbl.address2 IS '상세주소';
COMMENT ON COLUMN member_tbl.birthday IS '생일';
COMMENT ON COLUMN member_tbl.joindate IS '가입일';

ALTER TABLE member_tbl
ADD CONSTRAINT member_tbl_id_pk PRIMARY KEY(id);
 
ALTER TABLE member_tbl
ADD CONSTRAINT member_tbl_email_u UNIQUE(email);
 
ALTER TABLE member_tbl
ADD CONSTRAINT member_tbl_mobile_u UNIQUE(mobile);

ALTER TABLE member_tbl
MODIFY (name CONSTRAINT member_tbl_pw_nn NOT NULL);
 
ALTER TABLE member_tbl
MODIFY (name CONSTRAINT member_tbl_name_nn NOT NULL);
 
ALTER TABLE member_tbl
MODIFY (gender CONSTRAINT member_tbl_gender_nn NOT NULL);
 
ALTER TABLE member_tbl
MODIFY (email CONSTRAINT member_tbl_email_nn NOT NULL);
 
ALTER TABLE member_tbl
MODIFY (mobile CONSTRAINT member_tbl_mobile_nn NOT NULL);
