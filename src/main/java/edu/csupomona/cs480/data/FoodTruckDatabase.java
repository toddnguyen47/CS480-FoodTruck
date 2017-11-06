package edu.csupomona.cs480.data;


import edu.csupomona.cs480.App;
import edu.csupomona.cs480.data.provider.FoodTruckDatabaseManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;


public class FoodTruckDatabase implements FoodTruckDatabaseManager {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    @Autowired
    JdbcTemplate jdbcTemplate;


    public void createDatabase(){



    }


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


}
