package edu.csupomona.cs480.data.provider;

import java.util.List;

import edu.csupomona.cs480.data.TruckInfo;

public interface TruckInfoManager {
	public TruckInfo getTruckInfo(String truckId);
	public void updateTruckInfo(TruckInfo truck);
	public void deleteTruckInfo(String truckId);
	public List<TruckInfo> listAllTrucks();	

}
