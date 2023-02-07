package com.comic.domain;

import java.util.Date;

import lombok.Data;

/*CREATE TABLE WEBTOON_EPISODE(
		EPISODE_ID NUMBER(10),				--웹툰 번호
		WEBTOON_TITLE VARCHAR2 (20 CHAR),	--웹툰 제목
		EPISODE_TITLE VARCHAR2 (10),		--에피소드 제목
		EPISODE_GRAED NUMBER(4,2),			--에피소드 별점
		EPISODE_LIKE NUMBER(20),			--에피소드 좋아요
		EPISODE_DATE DATE DEFAULT SYSDATE,	--에피소드 등록일
		EPISODE_TEXT VARCHAR2 (400),		--작가의 말
		EPISODE_COVER VARCHAR2 (100)		--에피소드 표지
	);*/

@Data
public class WebtoonEpisodeDAO {
	private int episodeId;
	private String webtoonTitle;
	private String episodeTitle;
	private int episodeGraed;
	private int episodeLike;
	private Date episodeDate;
	private String episodeText;
	private String episodeCover;
	
}
