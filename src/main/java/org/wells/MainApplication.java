package org.wells;//abhishek360

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args){
        Map<String, String> env = System.getenv();
        System.out.println("Environment Variables:"+env.get("DB_USERNAME"));
        SpringApplication.run(MainApplication.class, args);
    }
}
