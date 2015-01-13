package Crawler_new;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class NewTest {
	public static void main(String[] args) throws Exception{
		Document doc=Jsoup.connect("http://localhost:800/ecmall/test2.htm").timeout(20000).get();
//		System.out.println(doc.toString());
		Element element=doc.select("h2.name").first();
		String name=element.text();
		System.out.println(name);
		Element elementPrice=doc.select("span[class^=currentPrice]").first();
		String price=elementPrice.text().substring(1);
		System.out.println(price);
	}
}
