package com.comic.domain;

import lombok.Data;

/*CREATE TABLE NAVER_WEBTOON(
		WEBTOON_ID NUMBER(10) PRIMARY KEY NOT NULL,	--웹툰번호
		WEBTOON_TITLE VARCHAR2(20 CHAR),			--웹툰 제목
		WEBTOON_AGE VARCHAR2(10 CHAR),				--연령
		WEBTOON_INFO VARCHAR2(100 CHAR),			--소개
		WEBTOON_GPA NUMBER(4,2),					--평점
		WEBTOON_LIKE NUMBER(20),					--좋아요
		WEBTOON_COVER VARCHAR2(100), 				--표지
		WEBTOON_INTRD_COVER VARCHAR2(100) 			--디테일 표지
	);*/

@Data
public class NaverWebtoonDTO {
	private int webtoonId;
	private String webtoonTitle;
	private String webtoonAge;
	private String webtoonInfo;
	private String webtoonGpa;
	private int webtoonLike;
	private String webtoonCover;
	private String webtoonIntrdCover;
}
