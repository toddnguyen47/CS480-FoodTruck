package edu.csupomona.cs480.data;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edu.csupomona.cs480.data.provider.FoodTruckYelpManager;

public class FoodTruckYelp implements FoodTruckYelpManager {

	private String foodTruckName;
	private String foodTruckAddress;
	private String foodTruckNumber;
	private String urlLink = "https://www.yelp.com/search?find_desc=food+truck&find_loc=pomona%2C+ca&ns=1";
	private Document doc;
	private Elements foodTruckNames;
	
	private Elements getLinks() {
		try {
			doc = Jsoup.connect(urlLink).get();
			foodTruckNames = doc.select("a[class=biz-name js-analytics-click] span");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return foodTruckNames;
	}
	
	@Override
	public ArrayList<String> getFoodTruckName() {
		ArrayList<String> elementList = new ArrayList<String>();
		Elements elements = getLinks();
		for (Element e : elements) {
			elementList.add(e.text());
		}
		
		return elementList;
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
		ArrayList<String> elementList = fty.getFoodTruckName();
		for (String s : elementList) {
			System.out.println(s);
		}
	}
	
}