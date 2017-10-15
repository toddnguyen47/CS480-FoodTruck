package edu.csupomona.cs480.data.provider;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.net.InetAddress;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.csupomona.cs480.data.GeoIP;
import edu.csupomona.cs480.data.TruckInfo;
import edu.csupomona.cs480.data.TruckMap;
import edu.csupomona.cs480.util.ResourceResolver;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.*;
import com.maxmind.geoip2.model.CityResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.FileSystemResourceLoader; 

public class FSTruckInfoManager implements TruckInfoManager{
	
	private static final ObjectMapper JSON = new ObjectMapper();
	private static DatabaseReader dbReader = null;
	private ResourceLoader resourceLoader;
	private static final String googleurl = "https://www.google.com";
	private static final String searchStr = "/search?newwindow=1&tbm=lcl&q=food+truck+near+me&oq=food+truck+near+me";
	public GeoIP getLocation(String ip) {
        GeoIP item = null;
     	try{
    		Resource testResource = null;
    		ResourceLoader testResourceLoader = new FileSystemResourceLoader();
    		try{
    			 testResource = testResourceLoader.getResource("GeoLite2-City.mmdb" );  	   
    			 if(!testResource.exists()){
    				System.out.println("Could not load test resource: " + testResource);
    			}
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    		
    		File database = testResource.getFile();
    		DatabaseReader reader = new DatabaseReader.Builder(database).build();
    
    		InetAddress ipAddress = InetAddress.getByName(ip);
	    	
	    	CityResponse response = reader.city(ipAddress);
	    	String cityName = response.getCity().getName();
	        String latitude = response.getLocation().getLatitude().toString();
	        String longitude = response.getLocation().getLongitude().toString();
	        return new GeoIP(ip, cityName, latitude, longitude);
        } catch(AddressNotFoundException e){
        	System.out.println("address not found...");
        }catch (GeoIp2Exception e) {  
        } catch (IOException e) {	
        	e.printStackTrace();
        }catch (Exception e) {	
        	e.printStackTrace();
        }
       return item;
    }
    
    @Override
	public List<TruckInfo> getGoogleList() throws IOException{
		
		
		Document doc = null;
		List<TruckInfo> truckInfos = new ArrayList<TruckInfo>();
		try{
			doc = Jsoup.connect(new String(googleurl + searchStr)).get();
			Elements newsHeadLines = doc.select("div[class=_gt] div[class=_rl]");
			
			for(int i= 0; i < newsHeadLines.size(); i++){
				TruckInfo item = new TruckInfo();
				item.setName(newsHeadLines.get(i).text());
				truckInfos.add(item);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		return truckInfos;
	}
    @Override
    public GeoIP getGeoIP() throws IOException{
    	String address = InetAddress.getLocalHost().getHostAddress();
		//System.out.println("Current IP address: " + address);
		/* problem current home location is not location in the db therefore using the 128.101.101.101*/
		
		GeoIP g = getLocation("128.101.101.101");
		//GeoIP g = getLocation(address);
		System.out.println(g);
		System.out.println("testing GeoIP: " + g.getIpAddress() + ", longitude: " + g.getLongitude() + ", latitude: " + g.getLatitude());
		return g;
    }
	
	public TruckMap getTruckMap(){
		TruckMap truckMap = null;
		File truckFile = ResourceResolver.getTruckFile();
		if(truckFile.exists()){
			try{
				truckMap = JSON.readValue(truckFile, TruckMap.class);
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{
			truckMap = new TruckMap();
		}
		return truckMap;
	}
	
	private void persistTruckMap(TruckMap truckMap){
		try{
			JSON.writeValue(ResourceResolver.getTruckFile(), truckMap);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	

	@Override
	public TruckInfo getTruckInfo(String truckId){
		TruckMap truckMap = getTruckMap();
		return truckMap.get(truckId);
	}
	@Override
	public void updateTruckInfo(TruckInfo truck){
	    TruckMap truckMap = getTruckMap();
		truckMap.put(truck.getId(), truck);
		persistTruckMap(truckMap);
	}
	@Override
	public void deleteTruckInfo(String truckId){
		TruckMap truckMap = getTruckMap();
		truckMap.remove(truckId);
		persistTruckMap(truckMap);
	}
	@Override
	public List<TruckInfo> listAllTrucks(){
		TruckMap truckMap = getTruckMap();
		return new ArrayList<TruckInfo>(truckMap.values());
	}
	@Override
	public List<TruckInfo> searchGoogleResult() throws IOException{
		TruckMap truckMap = getTruckMap();
		List<TruckInfo> result = getGoogleList();
		return result;
	}

}
