package Crawler_new;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class UseJsoupLinkListGetter {
	private String url;
	public UseJsoupLinkListGetter(String url){
		this.url=url;
	}
	public ArrayList<LinkDetails> getLinkList(){
		ArrayList<LinkDetails> linkList=new ArrayList<LinkDetails>();
		try{
			int number;
			String itemId;
			String juId;
			String link;
			
			//用jsoup解析http
			Document doc = Jsoup.connect(url).timeout(20000).get();  
			String ajaxurl=doc.select("div[class^=l-floor]").first().attr("data-ajaxurl");
			
			//用httpclient获得ajax返回的json内容
            HttpClient httpclient = HttpClients.custom().build();  
			HttpGet httpget = new HttpGet(ajaxurl);
            CloseableHttpResponse response = (CloseableHttpResponse) httpclient.execute(httpget);  
            HttpEntity entity = response.getEntity(); 
            String jsonString=EntityUtils.toString(entity);
            //使用org.json解析json
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray itemList = jsonObject.getJSONArray("itemList");
            for(int i=0;i<itemList.length();i++){
            	itemId=itemList.getJSONObject(i).getJSONObject("baseinfo").getString("itemId");
            	juId=itemList.getJSONObject(i).getJSONObject("baseinfo").getString("juId");
            	link="http://detail.ju.taobao.com/home.htm?item_id="+itemId+"&id="+juId;
            	number=Integer.valueOf(itemList.getJSONObject(i).getJSONObject("remind").getString("remindNum"));
            	if(number==0){
            		number=Integer.valueOf(itemList.getJSONObject(i).getJSONObject("remind").getString("soldCount"));
            	}
            	linkList.add(new LinkDetails(link,number));
            }
			
		  }catch(Exception e){
			  
		  }			
		return linkList;
	}
	public int getNumber(Element element){
		int number;
		String numberStr=element.select("span.sold-num").select("em").text();
		if(numberStr.equals("")){
			number=0;
		}else number=Integer.parseInt(numberStr);
		return number;
	}
}
