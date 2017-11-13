package edu.csupomona.cs480;


import edu.csupomona.cs480.data.FoodTruckDatabase;
import edu.csupomona.cs480.data.TruckInfo;
import edu.csupomona.cs480.data.repository.TruckRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)

/**
 * Unit test for DB insert and check data
 * Please import db schema in db-schema
 */
public class JpaMySQLdataBasetest {


    @Autowired
    public TruckRepository truckRepo;


    @Test
    public void testJPA() {
        truckRepo.deleteAll();
        TruckInfo foodTruck1 = new TruckInfo();
        foodTruck1.setName("New Asian3");
        foodTruck1.setAreaCode(626);
        foodTruck1.setAddress("new address");
        foodTruck1.setPhoneNumber("2678988");
        foodTruck1.setType("Thai");
        foodTruck1.setCity("Alhambra");
        foodTruck1.setImageUrl("Url");
        foodTruck1.setLat(30);
        foodTruck1.setLon(30);
        truckRepo.save(foodTruck1);
    }

   @Test
   public void testJPA2 () {
       TruckInfo foodTruck1 = new TruckInfo();
       String truckName = "trrtg";
       String truckType = "Mexican";
       String truckZipCode = "90210";
       String truckPhone = "8590903";
       int truckAreaCode = 818;
       String truckCity = "Beverly Hills";
       String truckAddress = "1442 S Euclid Ave";
       String imageURL = "URL";
       double truckLat = 34.198064099999996;
       double truckLon = -118.23511920000001;

       foodTruck1.setName(truckName);
       foodTruck1.setAreaCode(truckAreaCode);
       foodTruck1.setAddress(truckAddress);
       foodTruck1.setPhoneNumber(truckPhone);
       foodTruck1.setType(truckType);
       foodTruck1.setCity(truckCity);
       foodTruck1.setImageUrl(imageURL);
       foodTruck1.setLat(truckLat);
       foodTruck1.setLon(truckLon);
       truckRepo.save(foodTruck1);
   }

    @Test
    public void testJPA3ListAll (){


        //TruckInfo foodTruck1 = new TruckInfo();
        Iterable<TruckInfo> trucklist = truckRepo.findAll();




    }
    @Test
    public void testLoadTrucks() {
        List<TruckInfo> trucks = (ArrayList<TruckInfo>) truckRepo.findAll();
        assertEquals("Did not get all trucks", 4, trucks.size());
    }

}
