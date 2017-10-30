
/*
 * Copyright 2017 Optimize Prime
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
	public void createJson(String type, String address,String city) throws IOException {
		
		String id="fTWOWAvp3YzK9u8mCsMeWw";
		String secret="8cE7x0rZ0sm3nvgYpC5mXbmDz4qpBWxNGjFe04ZmYrQOYvk3Dx2UXaJsyFFl1cM8";
		YelpAPI yelp = newInstance(id,secret);
		Address loc = new Address();
		loc.address1=address;
		loc.city=city;
		Category cat = new Category();
		YelpSearchRequest request =  YelpSearchRequest.newBuilder()
				.withSearchTerm(type)
				.withLocation(loc)
			    .withCategories(cat.with("foodtrucks","Food Trucks"))
			    .withRadiusInMeters(40000)
			    .withSortBy(YelpSearchRequest.SortType.DISTANCE)
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
