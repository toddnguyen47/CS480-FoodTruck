package edu.csupomona.cs480.data.provider;

import java.util.List;
import java.io.IOException;

import edu.csupomona.cs480.data.TruckInfo;
import edu.csupomona.cs480.data.GeoIP;
import edu.csupomona.cs480.data.GoogleGeoCode;

public interface TruckInfoManager {


	public TruckInfo getTruckInfo(Integer truckId);
	public void updateTruckInfo(TruckInfo truck);
	public void deleteTruckInfo(Integer truckId);
	public List<TruckInfo> listAllTrucks();	
	public List<TruckInfo> searchGoogleResult() throws IOException;
	
	/**
	 * Code based on GetYelpData
	 * @param type - Type of food
	 * @param address - Address of user
	 * @param city - City of user
	 * @param lat - Latitude of user
	 * @param lon - Longitude of user
	 * @return A List of TruckInfo
	 * @throws IOException
	 */
	public List<TruckInfo> searchYelp(String type, String address,String city,double lat, double lon) throws IOException;
	
	List<TruckInfo> getGoogleList() throws IOException;
	GeoIP getGeoIP() throws IOException;
	GoogleGeoCode getGeoCode(String address, boolean ssl, String API_KEY) throws Exception;

}
