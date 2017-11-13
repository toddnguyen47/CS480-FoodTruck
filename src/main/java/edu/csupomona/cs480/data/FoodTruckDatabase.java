package edu.csupomona.cs480.data;


import edu.csupomona.cs480.App;
import edu.csupomona.cs480.data.provider.FoodTruckDatabaseManager;
import edu.csupomona.cs480.data.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class FoodTruckDatabase implements FoodTruckDatabaseManager {



    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    TruckRepository foodTrucks;

    @Autowired
    TruckInfo Truckinfo1;



    public FoodTruckDatabase(){
        String name = " ";
        String type = " ";
        String zipCode = " ";
        String phoneNumber = " ";
        String areaCode = " ";
        String city = " ";
        String address = " ";
        double lat = 0;
        double lon = 0;

    }


    public List<TruckInfo> listAllTrucks() {
        System.out.println("Query All Trucks");
        List<TruckInfo> list = (ArrayList<TruckInfo>) foodTrucks.findAll();

        return list;
    }

    public List<TruckInfo> findTruckByName(String name) {
        System.out.println("Finding truck by name");
        List<TruckInfo> resultsList = foodTrucks.findByName(name);
        return resultsList;
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
                name, type,zipCode, phoneNumber, areaCode, city, address,lat , lon);
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
