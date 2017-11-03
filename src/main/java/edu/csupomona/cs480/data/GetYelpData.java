
package edu.csupomona.cs480.data;
import okhttp3.*;
import okhttp3.Request.Builder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GetYelpData{
	@SuppressWarnings("unchecked")
	public static void createJson(String type, String address,String city,double lat, double lon) throws IOException {
		
	
		String accessToken="";
		OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "client_id=fTWOWAvp3YzK9u8mCsMeWw&"
        		+ "client_secret=8cE7x0rZ0sm3nvgYpC5mXbmDz4qpBWxNGjFe04ZmYrQOYvk3Dx2UXaJsyFFl1cM8"
        		+ "&grant_type=client_credentials");
        Request request= new Request.Builder()
                    .url("https://api.yelp.com/oauth2/token")
                    .post(body)
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "8d9de8ad-800c-50e1-fb4a-46fcb5f2f209")
                    .addHeader("content-type", "application/x-www-form-urlencoded")
                    .build();
        try {
            Response response = client.newCall(request).execute();
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(response.body().string().trim());
            JSONObject jsonObjectToken = (JSONObject) obj;
            accessToken = (String) jsonObjectToken.get("access_token");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        OkHttpClient client2 = new OkHttpClient();

        File f = new File("foodTruck.json");
		if(f.exists())
			f.delete();
        String term = type; 
        String location="";
        Request request2;
        if(address!=null) {
        	if(address.equals(""))
            	location = city;            
        	else
        		location=address + " " + city;
            request2 = new Builder()
                    .url("https://api.yelp.com/v3/businesses/search?term=" + term 
                    		+ "&location=" + location 
                    		+ "&radius=8046"
                    		+ "&categories=foodtrucks"
                    		+ "&sort_by=best_match")
                    .get()
                    .addHeader("authorization", "Bearer"+" "+accessToken)
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "b5fc33ce-3dad-86d7-6e2e-d67e14e8071b")
                    .build();
        }
        else {
            request2 = new Builder()
                    .url("https://api.yelp.com/v3/businesses/search?term=" + term 
                    		+ "&latitude=" + lat 
                    		+ "&longitude=" + lon 
                    		+ "&radius=8046"
                    		+ "&categories=foodtrucks"
                    		+ "&sort_by=best_match")
                    .get()
                    .addHeader("authorization", "Bearer"+" "+accessToken)
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "b5fc33ce-3dad-86d7-6e2e-d67e14e8071b")
                    .build();
        }

        try {
        	Gson gson = new GsonBuilder().setPrettyPrinting().create();
        	
            Response response2 = client2.newCall(request2).execute();
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(response2.body().string());
            JSONObject jsonObject = (JSONObject) obj;       // parser
            JSONArray list = (JSONArray) jsonObject.get("businesses");
            int size = list.size();
            if(size>=40)
            	size=40;
            JSONObject res = new JSONObject();
            for(int i=0;i<size;i++) {
            	JSONObject temp = (JSONObject) list.get(i);
            	JSONArray fT = new JSONArray();
    			TruckInfo truck = new TruckInfo();
    			truck.setId((String) temp.get("id"));
            	fT.add("ID: "+truck.getId());
    			
    			truck.setName((String) temp.get("name"));
    			fT.add("Name: "+truck.getName());
    			
    			truck.setType(type);
    			fT.add("Type: "+type);
    			
    			JSONObject tempLoc = (JSONObject) temp.get("location");
    			truck.setAddress((String) tempLoc.get("address1"));
    			fT.add("Address: "+truck.getAddress());
    			
    			truck.setPhoneNumber((String) temp.get("phone"));
    			fT.add("Phone Number: "+truck.getPhoneNumber());
    			
    			truck.setCity((String) tempLoc.get("city"));
    			fT.add("City: "+truck.getCity());
    			
    			truck.setZipCode((String) tempLoc.get("zip_code"));
    			fT.add("Zipcode: "+truck.getZipCode());
    			
    			JSONObject tempCoord = (JSONObject) temp.get("coordinates");
    			truck.setLat( Double.parseDouble( tempCoord.get("latitude").toString() ));
    			fT.add("Latitude: "+truck.getLat());
    			
    			truck.setLon(Double.parseDouble( tempCoord.get("longitude").toString() ));
    			fT.add("Longitude: "+truck.getLon());
    			
    			res.put(truck.getName(), fT);
            }
            try (FileWriter file = new FileWriter("foodTruck.json")) {
            	gson.toJson(res,file);
            }
        } 
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
		
	}
	
}
