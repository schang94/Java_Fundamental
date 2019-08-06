package java_20190806;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingDemo {
	public static void main(String[] args) {
		/*String url = "http://www.imbc.com";
		// HTML 문서 전체를 관리하기 위한 객체
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Elements elements = doc.select(".con-wrap.notice-wrap");
		
		Elements noticElement = elements.select("h3");
		String noticTitle = noticElement.text();
		System.out.println(noticTitle);
		
		Elements llelements = elements.select("li");
		for (int i = 0; i < llelements.size(); i++) {
			Element lielemnet = llelements.get(i);
			System.out.println(lielemnet.text());
		}*/
		
		String url = "https://sports.news.naver.com/kfootball/index.nhn";
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Elements elements = doc.select(".home_news");
		
		
		Elements llelements = elements.select(".home_news_list li");
		for (int i = 0; i < llelements.size(); i++) {
			Element lielemnet = llelements.get(i);
			System.out.println(lielemnet.text());
		}
	}
}
