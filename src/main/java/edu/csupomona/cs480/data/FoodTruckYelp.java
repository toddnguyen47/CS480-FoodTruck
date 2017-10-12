package edu.csupomona.cs480.data;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import edu.csupomona.cs480.data.provider.FoodTruckYelpManager;

public class FoodTruckYelp implements FoodTruckYelpManager {

	private String urlLink = "https://www.yelp.com/search?find_desc=food+truck&find_loc=pomona%2C+ca&ns=1";
	private String regularSearchResults = "li[class=regular-search-result] "; // will be used for Jsoup calls
	
	private Document getLinks() {
		Document doc = null;
		try {
			doc = Jsoup.connect(urlLink).get();		
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return doc;
	}
	
	@Override
	public ArrayList<String> getFoodTruckName() {
		Document doc = getLinks();
		Elements foodTruckNames = doc.select("span[class=indexed-biz-name] a[class=biz-name js-analytics-click] span");
		ArrayList<String> elementList = new ArrayList<String>();
		for (Element e : foodTruckNames) {
			elementList.add(e.text());
		}
		
		return elementList;
	}

	@Override
	public ArrayList<String> getFoodTruckAddress() {
		Document doc = getLinks();
		Elements foodTruckAddresses = doc.select(regularSearchResults + "div[class=biz-listing-large] address");
		ArrayList<String> elementList = new ArrayList<String>();
		for (Element e : foodTruckAddresses) {
			elementList.add(e.text());
		}
		return elementList;
	}

	@Override
	public ArrayList<String> getFoodTruckNumber() {
		Document doc = getLinks();
		Elements foodTruckNumbers = doc.select(regularSearchResults + "div[class=secondary-attributes] span[class=biz-phone]");
		ArrayList<String> elementList = new ArrayList<String>();
		for (Element e : foodTruckNumbers) {
			String temp = e.text();
			if (temp.compareToIgnoreCase("") == 0) {
				temp = "No phone number";
			}
			elementList.add(temp);
		}
		return elementList;
	}
}