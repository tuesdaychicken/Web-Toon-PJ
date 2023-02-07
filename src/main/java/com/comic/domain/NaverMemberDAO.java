package com.comic.domain;

import java.util.Date;

import lombok.Data;

/*CREATE TABLE NAVER_MEMBER(
		USER_NUM NUMBER(20) PRIMARY KEY NOT NULL,	--유저번호
		USER_ID VARCHAR2(20) NOT NULL,				--아이디
		USER_PW VARCHAR2(16) NOT NULL,				--패스워드
		USER_NAME VARCHAR2(6) NOT NULL,				--이름
		USER_BDAY DATE DEFAULT SYSDATE,				--생일
		USER_PHONE NUMBER(11),						--전화번호
		USER_NICKNAME VARCHAR2(10),					--닉네임
		USER_LEVEL NUMBER (2),						--유저 레벨
		USER_PHOTO VARCHAR2(50)						--사진
	);*/

@Data
public class NaverMemberDAO {

	private int userNum;
	private String userId;
	private String userPw;
	private String userName;
	private Date userBday;
	private int userPhone;
	private String userNickname;
	private int userLevel;
	private String userPhoto;
}
