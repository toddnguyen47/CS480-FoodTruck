package edu.csupomona.cs480;

import edu.csupomona.cs480.data.provider.FoodTruckDatabaseManager;
import org.junit.Assert;
import org.junit.Test;

/**
 * This makes sure that the file contains at least one instance of the following:
 * name, image_url, url, coordinates, location, and display_phone.
 * @author Allen Artoonian
 */
public class MySQLdataBasetest {
   @Test
   public void testGetDisplayName() {

       String truckName = "testTruck";
       String truckType = "Mexican";
       String truckZipCode = "90210";
       String truckPhone = "8590903";
       String truckAreaCode = "818";
       String truckCity = "Beverly Hills";
       String truckAddress = "1442 S Euclid Ave";
       double truckLat = 34.198064099999996;
       double truckLon = -118.23511920000001;


       FoodTruckDatabaseManager ftdmTest = null;

       //ftdmTest.addTruck(truckName,truckType,truckZipCode,truckPhone,truckAreaCode,truckCity,truckAddress,truckLat,truckLon);
       Assert.assertEquals(1,ftdmTest.addTruck(truckName,truckType,truckZipCode,truckPhone,truckAreaCode,truckCity,truckAddress,truckLat,truckLon));
   }
}
