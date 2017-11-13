package edu.csupomona.cs480;


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
public class CHIWEIWANGA6test {
	@Autowired
	public TruckRepository truckRepositry;

	@Test
	 public void testTruck() {
		truckRepositry.deleteAll();	
			TruckInfo t1 = new TruckInfo();
			t1.setName("New Asian3");
			t1.setType("Thai");
			t1.setZipCode("91020");
			t1.setPhoneNumber("2678988");
			t1.setAreaCode(626);
			t1.setAddress("new address");


			t1.setCity("Alhambra");
			t1.setImageUrl("Url");
			t1.setLat(30);
			t1.setLon(30);
			truckRepositry.save(t1);
			List<TruckInfo> list = (ArrayList<TruckInfo>) truckRepositry.findAll();
			assertEquals("Only one item in the list", 1, list.size());
			assertEquals("Truck name is", "New Asian3", list.get(0).getName());
			truckRepositry.deleteAll();
	 }
}
