package edu.csupomona.cs480;

import edu.csupomona.cs480.data.provider.FoodTruckDatabaseManager;
import edu.csupomona.cs480.data.FoodTruckDatabase;
import org.junit.Assert;
import org.junit.Test;

/**
 * This makes sure that the file contains at least one instance of the following:
 * name, image_url, url, coordinates, location, and display_phone.
 * @author Allen Artoonian
 */

// Spring boot base config class
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


       FoodTruckDatabase ftdmTest;
       ftdmTest = new FoodTruckDatabase();

       //ftdmTest.addTruck(truckName,truckType,truckZipCode,truckPhone,truckAreaCode,truckCity,truckAddress,truckLat,truckLon);
       //ftdmTest.addTruck("1sd","ds2","3","4","5","6","7",8,9);
       //Assert.assertEquals(1,ftdmTest.addTruck(truckName,truckType,truckZipCode,truckPhone,truckAreaCode,truckCity,truckAddress,truckLat,truckLon));
       // ftdmTest.queryUser();
   }
}
