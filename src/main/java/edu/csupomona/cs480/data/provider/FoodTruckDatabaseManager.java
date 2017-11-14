package edu.csupomona.cs480.data.provider;

import edu.csupomona.cs480.data.TruckInfo;

import java.util.ArrayList;
import java.util.List;

/**

 * @author Allen Artoonian
 *
 */
public interface FoodTruckDatabaseManager {

    public void addTruckToDB(String truckName,String truckType,String truckZipCode,String truckPhone,int truckAreaCode,String truckCity,String truckAddress,String imageURL , double truckLat,double truckLon );
    public List<TruckInfo> listAllTrucks();
    public  ArrayList<String> getFoodTruckName();
    public  ArrayList<String> getFoodTruckAddress();
    public  ArrayList<String> getFoodTruckNumber();
}
