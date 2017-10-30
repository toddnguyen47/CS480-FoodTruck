package edu.csupomona.cs480.data;
import tech.redroma.yelp.*;
import tech.redroma.yelp.YelpAPI.Builder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import tech.sirwellington.alchemy.annotations.arguments.NonEmpty;
import static tech.sirwellington.alchemy.arguments.Arguments.checkThat;
import static tech.sirwellington.alchemy.arguments.assertions.StringAssertions.nonEmptyString;

import java.util.ArrayList;
import java.util.List;

public class GetYelpData{

	@SuppressWarnings("unchecked")
	public void createJson(String type, String zip) throws IOException {
		
		String id="fTWOWAvp3YzK9u8mCsMeWw";
		String secret="8cE7x0rZ0sm3nvgYpC5mXbmDz4qpBWxNGjFe04ZmYrQOYvk3Dx2UXaJsyFFl1cM8";
		YelpAPI yelp = newInstance(id,secret);
		Address loc = new Address();
		loc.zipCode=zip;
		Category cat = new Category();
		YelpSearchRequest request =  YelpSearchRequest.newBuilder()
				.withSearchTerm(type)
				.withCoordinate(Coordinate.of(34.018363, -118.492343))
			    .withCategories(cat.with("foodtrucks","Food Trucks"))
			    .build();
		
		List<YelpBusiness> results = yelp.searchForBusinesses(request);
		JSONObject obj = new JSONObject();
		for(int i=0;i<results.size();i++) {
			
			JSONArray fT = new JSONArray();
			TruckInfo truck = new TruckInfo();
			
			truck.setId(results.get(i).id);
			fT.add("ID: "+truck.getId());
			
			truck.setName(results.get(i).name);
			fT.add("Name: "+truck.getName());
			
			truck.setType(type);
			fT.add("Type: "+type);
			
			truck.setAddress(results.get(i).location.address1);
			fT.add("Address: "+truck.getAddress());
			
			truck.setPhoneNumber(results.get(i).phone);
			fT.add("Phone Number: "+truck.getPhoneNumber());
			
			truck.setCity(results.get(i).location.city);
			fT.add("City: "+truck.getCity());
			
			truck.setZipCode(results.get(i).location.zipCode);
			fT.add("Zipcode: "+truck.getZipCode());
			
			truck.setLat(results.get(i).coordinates.getLatitude());
			fT.add("Latitude: "+truck.getLat());
			
			truck.setLon(results.get(i).coordinates.getLongitude());
			fT.add("Longitude: "+truck.getLon());
			
			obj.put(truck.getName(), fT);
		}
		File f = new File("foodTruck.json");
		if(f.exists())
			f.delete();
		try (FileWriter file = new FileWriter("foodTruck.json")) {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(obj,file);
		}
	}
	
	/*
	 * Taken from Redroma's YelpAPI interface as their method of using a static interface method cannot be used in JDK 7.
	 */
	private YelpAPI newInstance(@NonEmpty String cliendId, @NonEmpty String clientSecret)
    {
        checkThat(cliendId, clientSecret)
            .are(nonEmptyString());
        
        return Builder.newInstance()
            .withClientCredentials(cliendId, clientSecret)
            .build();
    }
}
