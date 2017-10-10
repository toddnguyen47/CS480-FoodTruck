package edu.csupomona.cs480.data;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import edu.csupomona.cs480.data.provider.FoodTruckYelpManager;

public class FoodTruckYelp implements FoodTruckYelpManager {

	private String foodTruckName;
	private String foodTruckAddress;
	private String foodTruckNumber;
	private String urlLink = "https://www.yelp.com/search?find_desc=food+truck&find_loc=pomona%2C+ca&ns=1";
	private Document doc;
	private Elements foodTruckNames;
	
	private String getLinks() {
		try {
			doc = Jsoup.connect(urlLink).get();
			//foodTruckNames = doc.select("class.biz-name");
			foodTruckNames = doc.select("span");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return foodTruckNames.text();
	}
	
	@Override
	public String getFoodTruckName() {
		return getLinks();
	}

	@Override
	public String getFoodTruckAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFoodTruckNumber() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		FoodTruckYelp fty = new FoodTruckYelp();
		System.out.println("Hello!");
		System.out.println(fty.getFoodTruckName());
	}
	
}