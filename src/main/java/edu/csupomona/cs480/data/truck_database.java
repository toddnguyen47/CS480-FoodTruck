package edu.csupomona.cs480.data;


import edu.csupomona.cs480.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class truck_database {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    @Autowired
    JdbcTemplate jdbcTemplate;


    public void createDatabase(){
        jdbcTemplate.execute("DROP TABLE employee IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE employee(" + "id SERIAL, name VARCHAR(255))");
    }


        public void queryUser() {
            System.out.println("Query employees");
            String sql = "SELECT ID, NAME, AGE FROM EMPLOYEE";
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
            for (Map<String, Object> row : list) {
                System.out.println(row.get("name"));
            }
        }

        public void insertEmployee(final User user){
            System.out.println("Insert employee " + user);
            String sql = "INSERT into EMPLOYEE(ID, NAME, AGE) VALUES (?, ?, ?)";
            jdbcTemplate.update(
                    sql,
                    new Object[] { user.getId(), user.getName(),
                    });
    }


}
