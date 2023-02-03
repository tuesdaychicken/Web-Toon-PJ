package com.comic.parsing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.google.gson.Gson;

public class WebtoonCrawling {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Document doc = Jsoup.connect("https://comic.naver.com/webtoon/weekday").get();
		Elements webtoon = doc.select("div.daily_all");

		int week = webtoon.select("div.col h4").size();
		// 요일 갯수

		for (int i = 0; i < week; i++) {
			
			int webtoonNum = webtoon.select("div.col:eq("+i+") a.title").size();
			// i번째 요일 웹툰 갯수

			List<String> list = null;
			
			for (int j = 0; j < webtoonNum; j++) {
			
				list = new ArrayList<>();
				
				Map<String, String> map = new HashMap<>();
				
				String webtoonWeek = webtoon.select("div.col:eq("+i+") h4").text();
				map.put("webtoonWeek", webtoonWeek);
				//해당요일

				String webtoonCover = webtoon.select("div.col:eq("+i+") li:eq("+j+") img").attr("src");
				map.put("webtoonCover", webtoonCover);
				// 웹툰 커버 이미지
				
				String url = webtoon.select("div.col:eq("+i+") li:eq("+j+") a").attr("href");
				//i번째요일, j번째 웹툰 경로
				
				Document doc2 = Jsoup.connect("https://comic.naver.com"+url).get();
				
				Elements webtoonDetail = doc2.select("div.comicinfo");
				
				String webtoonIntrdCover = webtoonDetail.select("img").attr("src");
				map.put("webtoonIntrdCover", webtoonIntrdCover);
				// 웹툰 디테일 표지
						
				String webtoonTitle = webtoonDetail.select("div.detail span.title").text();
				map.put("webtoonTitle", webtoonTitle);
				// 웹툰 제목
						
				String webtoonWriter = webtoonDetail.select("div.detail span.wrt_nm").text();
				map.put("webtoonWriter", webtoonWriter);
				// 웹툰 작가
				
				String webtoonInfo = webtoonDetail.select("div.detail p").get(0).text();
				map.put("webtoonInfo", webtoonInfo);
				// 웹툰 소개글
						
				String webtoonGenre = webtoonDetail.select("div.detail p.detail_info span.genre").text();
				map.put("webtoonGenre", webtoonGenre);
				// 웹툰 장르
						
				String webtoonAge = webtoonDetail.select("div.detail p.detail_info span.age").text();
				map.put("webtoonAge", webtoonAge);
				// 웹툰 연령
				
				if(webtoon.select("div.col:eq("+i+") li:eq("+j+") em.ico_break").text().equals("휴재")) {
					String webtoonRemarks = webtoon.select("div.col:eq("+i+") li:eq("+j+") em.ico_break").text();
					map.put("webtoonRemarks", webtoonRemarks);
					//휴재여부 판단
				} else {
					map.put("webtoonRemarks", "");
				}
					
				if(webtoon.select("div.col:eq("+i+") li:eq("+j+") span.mark_adult_thumb").text().equals("18세 이상 이용 가능")) {
					String webtoonAdult = webtoon.select("div.col:eq("+i+") li:eq("+j+") span.mark_adult_thumb").text();
					map.put("webtoonAdult", webtoonAdult);
					//성인웹툰 여부 판단
				} else {
					map.put("webtoonAdult", "");
				}
					
				if(webtoon.select("div.col:eq("+i+") li:eq("+j+") span.ico_new2").text().equals("NEW")) {
					String webtoonNew = webtoon.select("div.col:eq("+i+") li:eq("+j+") span.ico_new2").text();
					map.put("webtoonNew", webtoonNew);
					//새로운 웹툰 여부 판단
				} else {
					map.put("webtoonNew", "");
				}
				
				
				String json = new Gson().toJson(map);
				
				list.add(json);
				System.out.println(list.toString());
			}
			
			
			
			
		}





		/*				
				String[] array = webtoonWriter.split(" / ");
				for(String arr : array) {
					System.out.println(arr);
				}
	넘어오는 값을 슬라이싱 해서 배열에 넣어주는 거
		 */
	}

}
