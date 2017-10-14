package edu.csupomona.cs480.data.provider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.csupomona.cs480.data.TruckInfo;
import edu.csupomona.cs480.data.TruckMap;
import edu.csupomona.cs480.util.ResourceResolver;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class FSTruckInfoManager implements TruckInfoManager{
	
	private static final ObjectMapper JSON = new ObjectMapper();
	private static final String googleurl = "https://www.google.com";
	private static final String searchStr = "/search?newwindow=1&tbm=lcl&q=food+truck+near+me&oq=food+truck+near+me";

	public List<TruckInfo> getGoogleList() {
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
	public List<TruckInfo> searchGoogleResult(){
		TruckMap truckMap = getTruckMap();
		List<TruckInfo> result = getGoogleList();
		return result;
	}

}
