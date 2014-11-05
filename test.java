package Crawler_new;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;



public class test {
	public static void main(String[] args) {
		try{

            HttpClient httpclient = HttpClients.custom().build();  
			HttpGet httpget = new HttpGet("http://ju.taobao.com/json/tg/ajaxGetItemsV2.json?type=0&frontCatId=35000");  
            System.out.println("executing request" + httpget.getRequestLine()); 
            CloseableHttpResponse response = (CloseableHttpResponse) httpclient.execute(httpget);  
            HttpEntity entity = response.getEntity();  
//            System.out.println("----------------------------------------");  
//            System.out.println(response.getStatusLine());  
//            System.out.println("Response content length: " + entity.getContentLength());  
//            System.out.println(EntityUtils.toString(entity));             
            String jsonString=EntityUtils.toString(entity);
            System.out.println(jsonString);
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray itemList = jsonObject.getJSONArray("itemList");
            for(int i=0;i<itemList.length();i++){
            	System.out.println(itemList.getJSONObject(i).getJSONObject("name").getString("shortName"));
            }
			
			
//			 Document doc = Jsoup.connect("http://ju.taobao.com/jusp/jiajupindao/tp.htm?spm=608.2291429.764795.21.MOMyT5").timeout(20000).get();  
//			 System.out.println(doc.toString());
//			 String link=doc.select("div[class^=l-floor]").first().attr("data-ajaxurl");
//			 System.out.println(link);
//			 Document doc2=Jsoup.connect(link).timeout(20000).get();
//			 System.out.println(doc2.toString());
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
}
