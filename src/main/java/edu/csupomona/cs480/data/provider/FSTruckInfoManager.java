package edu.csupomona.cs480.data.provider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.csupomona.cs480.data.TruckInfo;
import edu.csupomona.cs480.data.TruckMap;
import edu.csupomona.cs480.util.ResourceResolver;

public class FSTruckInfoManager implements TruckInfoManager{
	
	private static final ObjectMapper JSON = new ObjectMapper();
	
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
}
