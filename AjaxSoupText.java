package Crawler_new;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class AjaxSoupText {
	public static void main(String[] args) throws IOException {
//		Document doc = Jsoup.connect("http://ju.taobao.com/json/jusp/tpData.htm?urlKey=jiajupindao&amp;floorIndex=2").timeout(20000).get();
//		System.out.println(doc.toString());
		
		HttpClient httpclient = HttpClients.custom().build();  
		HttpGet httpget = new HttpGet("http://ju.taobao.com/json/jusp/tpData.htm?urlKey=jiajupindao&amp;floorIndex=2");
        CloseableHttpResponse response = (CloseableHttpResponse) httpclient.execute(httpget);  
        HttpEntity entity = response.getEntity(); 
        String jsonString=EntityUtils.toString(entity);
        System.out.println(jsonString);
	}
}
