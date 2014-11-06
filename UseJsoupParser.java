package Crawler_new;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class UseJsoupParser {
	private String productId;
	private String productName;
	private String shopName;
	private String companyName;
	private double price;
	private double origPrice;
	private double discount;
	private int numberOfPeople;
	private String type;
	private String startTime;
	private String endTime;
	private String status;




	private String picture;
	private String link;
	private String updateTime;

	public UseJsoupParser(){
		  origPrice=0;
		  discount=0;
		  type="����";
		  startTime="";
		  endTime="";
		  companyName="";
		  status="";
	}
	
	public void praseLink(LinkDetails linkDetails){
		try{
			  link=linkDetails.getLink();
			  productId=linkDetails.getLink().substring(linkDetails.getLink().indexOf("item_id")+"item_id".length()+1,
					  linkDetails.getLink().indexOf("&"));
			  System.out.println(link);
			  Document doc=Jsoup.connect(linkDetails.getLink()).timeout(5000).get();
			  
			  numberOfPeople=linkDetails.getNumberOfPeople();
			  if(doc.select("span[class^=sold]").first()!=null){
				  numberOfPeople=Integer.valueOf(doc.select("span[class^=sold]").first().select("span.num").text());
			  }
			  
			  if(doc.select("h2.name").first()!=null){
				  productName=doc.select("h2.name").first().text();	
				  shopName=doc.select("div.con").first().text();
				  
				  if(doc.select("div.field").get(2).select("div.term").first().text().startsWith("��˾��")){
					  companyName=doc.select("div.field").get(2).select("div.con").first().text();
				  }
				  
				  if(doc.select("div[data-itemprice]").first()!=null){
					  price=Double.valueOf(doc.select("div[data-itemprice]").first().attr("data-itemprice"));  
				  }else{
					  price=Double.valueOf(doc.select("span[class^=currentPrice]").first().text().substring(1));  
				  }
				  
				  if(doc.select("div.back-price").first()!=null){
					  String priceStr=doc.select("div.back-price").first().select("em").text();
					  price=Double.valueOf(priceStr.substring(1,priceStr.length()));
				  }
				  if(doc.select("div[data-originalprice]").first()!=null){
					  origPrice=Double.valueOf(doc.select("div[data-originalprice]").first().attr("data-originalprice"));
				  }	
				  if(doc.select("div[data-polldiscount]").first()!=null){
					  discount=Double.valueOf(doc.select("div[data-polldiscount]").first().attr("data-polldiscount")); 
				  }				  
				  DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				  updateTime=formatter.format(new Date());
				  
				  	//��ÿ�ʼ������ʱ��
				  if(doc.select("div[data-targettime][data-servertime]").first()!=null){
					  picture=doc.select("img[src][data-normal][data-big]").first().attr("src");
					  String tempTime=doc.select("div[data-targettime][data-servertime]").first().attr("data-targettime");	
					  
					  Calendar calendar = Calendar.getInstance();
					  calendar.setTimeInMillis(Long.valueOf(tempTime));
					  String timeStarOrEnd=formatter.format(calendar.getTime());
					  if(doc.select("div[data-targettime][data-servertime]").first().attr("data-type").equals("avil")){
						  endTime=timeStarOrEnd;

					  }else if(doc.select("div[data-targettime][data-servertime]").first().attr("data-type").equals("notbegin")){
						  startTime=timeStarOrEnd;
						  type="����";
					  }							  							  
				  }else{
					  picture=doc.select("img[src*=.jpg][class^=pic-unavil]").first().attr("src");
					  endTime="�ѽ���";
				  }					  
			  }	  

		  }catch(Exception e){
			  e.printStackTrace();
		  }
	}
	
	
	public String getProductId() {
		return productId;
	}



	public void setProductId(String productId) {
		this.productId = productId;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getShopName() {
		return shopName;
	}



	public void setShopName(String shopName) {
		this.shopName = shopName;
	}



	public String getCompanyName() {
		return companyName;
	}



	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public double getOrigPrice() {
		return origPrice;
	}



	public void setOrigPrice(double origPrice) {
		this.origPrice = origPrice;
	}



	public double getDiscount() {
		return discount;
	}



	public void setDiscount(double discount) {
		this.discount = discount;
	}



	public int getNumberOfPeople() {
		return numberOfPeople;
	}



	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStartTime() {
		return startTime;
	}



	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}



	public String getEndTime() {
		return endTime;
	}



	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPicture() {
		return picture;
	}



	public void setPicture(String picture) {
		this.picture = picture;
	}



	public String getLink() {
		return link;
	}



	public void setLink(String link) {
		this.link = link;
	}



	public String getUpdateTime() {
		return updateTime;
	}



	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}


}
