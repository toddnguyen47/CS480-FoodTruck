package edu.csupomona.cs480.data.provider;

import java.util.ArrayList;

/**

 * @author Allen Artoonian
 *
 */
public abstract class FoodTruckDatabaseManager {

    public abstract int addTruck(String name, String type, String zipCode, String phoneNumber, String areaCode, String City, String address, double lat, double lon);
    public abstract ArrayList<String> getFoodTruckName();
    public abstract ArrayList<String> getFoodTruckAddress();
    public abstract ArrayList<String> getFoodTruckNumber();
}
