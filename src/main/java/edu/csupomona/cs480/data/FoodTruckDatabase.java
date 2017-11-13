package edu.csupomona.cs480.data;


import edu.csupomona.cs480.App;
import edu.csupomona.cs480.data.provider.FoodTruckDatabaseManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class FoodTruckDatabase extends FoodTruckDatabaseManager {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    @Autowired
    JdbcTemplate jdbcTemplate;


    public void queryUser() {
        //System.out.println("Query Trucks");
        String sql = "SELECT * FROM truck_info";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> row : list) {
            System.out.println(row.get("name"));
            }
        }

    public void insertTruck(final User user){
         System.out.println("Insert truck " + user);
         String sql = "INSERT into EMPLOYEE(ID, NAME) VALUES (?, ?)";
         jdbcTemplate.update(
                sql,
                user.getId(), user.getName()
                );
    }
    @Override
    public int addTruck(String name, String type, String zipCode, String phoneNumber, String areaCode, String city, String address, double lat, double lon){
        jdbcTemplate.update("INSERT INTO truck_info(name, type,zip_code,phone_number,area_code,city,address,lat,lon ) VALUES (?,?,?,?,?,?,?,?,?)",
                name, type,zipCode, phoneNumber, areaCode,city, address,lat,lon);
        return 1;
    }

    @Override
    public ArrayList<String> getFoodTruckName(){
        ArrayList<String> elementList = new ArrayList<String>();

        return elementList;
    }

    @Override
    public ArrayList<String> getFoodTruckAddress(){
        ArrayList<String> elementList = new ArrayList<String>();

        return elementList;

    }
    @Override
    public ArrayList<String> getFoodTruckNumber(){

        ArrayList<String> elementList = new ArrayList<String>();

        return elementList;
    }

}
