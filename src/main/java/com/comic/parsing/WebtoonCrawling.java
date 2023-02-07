package com.comic.parsing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.comic.domain.NaverWebtoonDTO;

public class WebtoonCrawling {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Document doc = Jsoup.connect("https://comic.naver.com/webtoon/weekday").get();
		Elements webtoon = doc.select("div.daily_all");

		int week = webtoon.select("div.col h4").size();
		// 요일 갯수
		
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		
		for (int i = 0; i < week; i++) {

			int webtoonNum = webtoon.select("div.col:eq(" + i + ") a.title").size();
			// i번째 요일 웹툰 갯수

			for (int j = 0; j < webtoonNum; j++) {

				HashMap<String, String> crawlingData = new HashMap<>();

				String webtoonWeek = webtoon.select("div.col:eq(" + i + ") h4").text();
				crawlingData.put("webtoonWeek", webtoonWeek);
				// 해당요일

				String webtoonCover = webtoon.select("div.col:eq(" + i + ") li:eq(" + j + ") img").attr("src");
				crawlingData.put("webtoonCover", webtoonCover);
				// 웹툰 커버 이미지

				String url = webtoon.select("div.col:eq(" + i + ") li:eq(" + j + ") a").attr("href");
				// i번째요일, j번째 웹툰 경로

				Document doc2 = Jsoup.connect("https://comic.naver.com" + url).get();

				Elements webtoonDetail = doc2.select("div.comicinfo");

				String webtoonIntrdCover = webtoonDetail.select("img").attr("src");
				crawlingData.put("webtoonIntrdCover", webtoonIntrdCover);
				// 웹툰 디테일 표지

				String webtoonTitle = webtoonDetail.select("div.detail span.title").text();
				crawlingData.put("webtoonTitle", webtoonTitle);
				// 웹툰 제목

				String webtoonWriter = webtoonDetail.select("div.detail span.wrt_nm").text();
				crawlingData.put("webtoonWriter", webtoonWriter);
				// 웹툰 작가

				String webtoonInfo = webtoonDetail.select("div.detail p").get(0).text();
				crawlingData.put("webtoonInfo", webtoonInfo);
				// 웹툰 소개글

				String webtoonGenre = webtoonDetail.select("div.detail p.detail_info span.genre").text();
				crawlingData.put("webtoonGenre", webtoonGenre);
				// 웹툰 장르

				String webtoonAge = webtoonDetail.select("div.detail p.detail_info span.age").text();
				crawlingData.put("webtoonAge", webtoonAge);
				// 웹툰 연령

				if (webtoon.select("div.col:eq(" + i + ") li:eq(" + j + ") em.ico_break").text().equals("휴재")) {
					String webtoonPause = webtoon.select("div.col:eq(" + i + ") li:eq(" + j + ") em.ico_break").text();
					crawlingData.put("webtoonRemarks", webtoonPause);
					// 휴재여부 판단
				} else {
					crawlingData.put("webtoonRemarks", "");
				}

				if (webtoon.select("div.col:eq(" + i + ") li:eq(" + j + ") span.mark_adult_thumb").text()
						.equals("18세 이상 이용 가능")) {
					String webtoonAdult = webtoon.select("div.col:eq(" + i + ") li:eq(" + j + ") span.mark_adult_thumb")
							.text();
					crawlingData.put("webtoonAdult", webtoonAdult);
					// 성인웹툰 여부 판단
				} else {
					crawlingData.put("webtoonAdult", "");
				}

				if (webtoon.select("div.col:eq(" + i + ") li:eq(" + j + ") span.ico_new2").text().equals("NEW")) {
					String webtoonNew = webtoon.select("div.col:eq(" + i + ") li:eq(" + j + ") span.ico_new2").text();
					crawlingData.put("webtoonNew", webtoonNew);
					// 새로운 웹툰 여부 판단
				} else {
					crawlingData.put("webtoonNew", "");
				}

//				String json = new Gson().toJson(crawlingData); 제이슨으로 변형 히힣

				list.add(crawlingData);
				System.out.println(list.toString());
				
				ㅇㅇ ㅇㅇ 지금 그거부터 해야 너가 MVC 패턴부터 시작해서
				의존성 주입, 이것저것 다이해할 수 있을듯 너가 지금 하는거
				배치 파일 만드는거임 
				
				알아서 데이터 인서트 해주주는 프로그램을 배치라고 하는데
				대부분 어떤식으로 사용하냐면
				
				외부에서 데이터를 뭔가 받아와 그거를 내 테이블에다가 알아서 인서트 하게 시간을 정해놓고
				프로그램이 그 시간이 되면 한번 쫙 돌고 프로셋 ㅡ종료
			}

		}

		/*
		 * String[] array = webtoonWriter.split(" / "); for(String arr : array) {
		 * System.out.println(arr); } 넘어오는 값을 슬라이싱 해서 배열에 넣어주는 거
		 */
	}

}
