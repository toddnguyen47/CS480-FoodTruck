package edu.csupomona.cs480.data.provider;

import edu.csupomona.cs480.data.TruckInfo;

import java.util.ArrayList;
import java.util.List;

/**

 * @author Allen Artoonian
 *
 */
public interface FoodTruckDatabaseManager {

    public  int addTruck(String name, String type, String zipCode, String phoneNumber, String areaCode, String City, String address, double lat, double lon);
    public List<TruckInfo> listAllTrucks();
    public  ArrayList<String> getFoodTruckName();
    public  ArrayList<String> getFoodTruckAddress();
    public  ArrayList<String> getFoodTruckNumber();
}
