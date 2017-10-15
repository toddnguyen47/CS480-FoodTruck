package edu.csupomona.cs480.data.provider;

import java.util.List;
import java.io.IOException;

import edu.csupomona.cs480.data.TruckInfo;
import edu.csupomona.cs480.data.GeoIP;

public interface TruckInfoManager {

	public TruckInfo getTruckInfo(String truckId);
	public void updateTruckInfo(TruckInfo truck);
	public void deleteTruckInfo(String truckId);
	public List<TruckInfo> listAllTrucks();	
	public List<TruckInfo> searchGoogleResult() throws IOException;
	List<TruckInfo> getGoogleList() throws IOException;
	GeoIP getGeoIP() throws IOException;

}
