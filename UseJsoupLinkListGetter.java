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
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class UseJsoupLinkListGetter {
	private String url;
	private Connection conn;
	
	public UseJsoupLinkListGetter(String url){
		this.url=url;
	}
	
	public Connection getConnection(){
		return this.conn;
	}
	
	public ArrayList<LinkDetails> getLinkList(){
		ArrayList<LinkDetails> linkList=new ArrayList<LinkDetails>();
		try{
			int number;
			String itemId;
			String juId;
			String link;
			
			//��jsoup����http
			Document doc = Jsoup.connect(url).timeout(20000).get();
			//Ҫ���ж��������ַҳ���Ǿۻ���ķ���ҳ�滹��Ʒ���ŵ�ĳ��Ʒ��ҳ��
			if(doc.select("div[class][id][data-url]").first()==null&&doc.select("div[class][id][data-ajaxurl]").first()==null){//����Ǿۻ���ķ���ҳ��
				Element asasas=doc.select("div[class][id][data-url]").first();
				String ajaxurl=doc.select("div[class^=l-floor]").first().attr("data-ajaxurl");
				
				//��httpclient���ajax���ص�json����
	            HttpClient httpclient = HttpClients.custom().build();  
				HttpGet httpget = new HttpGet(ajaxurl);
	            CloseableHttpResponse response = (CloseableHttpResponse) httpclient.execute(httpget);  
	            HttpEntity entity = response.getEntity(); 
	            String jsonString=EntityUtils.toString(entity);
	            //ʹ��org.json����json
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
			}else{//�����Ʒ���ŵ�ĳ��Ʒ��ҳ��
				//����ר��
				Elements elementsOfFloor1=doc.select("li[class][id]");			  	
				for(Element elementOfFloor1:elementsOfFloor1){
				  link=elementOfFloor1.select("a[href]").first().attr("href");
				  number=getNumber(elementOfFloor1);//ֻ�й����������빺����������ϸҳ���ж�ȡ����	
				  linkList.add(new LinkDetails(link,number));
				  System.out.println("����");
				}
				
			  	//����ר��
				Elements elementsOfFloorOthers=doc.select("div[class^=l-floor]");
				System.out.println(elementsOfFloorOthers.size());
			    for(int i=1;i<elementsOfFloorOthers.size()-1;i++){
				    List<Attribute> tempAttributeList=elementsOfFloorOthers.get(i).attributes().asList();
				    String floorLink=tempAttributeList.get(tempAttributeList.size()-1).getValue();
				    System.out.println(floorLink);
				    Document docFloorOthers=Jsoup.connect(floorLink).timeout(10000).get();
				    Elements elementsOfFloori=docFloorOthers.select("a[href]");
				  	//�Ե�i��ר���е�������Ʒ����ѭ��
				    for(Element elementOfFloori:elementsOfFloori){
					    link=elementOfFloori.attr("href");							  
					    number=getNumber(elementOfFloori);;//ֻ�й����������빺����������ϸҳ���ж�ȡ����
					    linkList.add(new LinkDetails(link,number));
				    }							  
			    }
			}
		  }catch(Exception e){
			  
		  }			
		return linkList;
	}
	public int getNumber(Element element){
		int number;
		String numberStrFloor1=element.select("div.sold-num").select("em").text();
		String numberStrFloorOthers=element.select("span.sold-num").select("em").text();
		if(numberStrFloorOthers.equals("")&&!numberStrFloor1.equals("")){
			number=Integer.parseInt(numberStrFloor1);
		}else if(numberStrFloor1.equals("")&&!numberStrFloorOthers.equals("")){
			number=Integer.parseInt(numberStrFloorOthers);
		}else{
			number=0;
		}			
		return number;
	}
}
