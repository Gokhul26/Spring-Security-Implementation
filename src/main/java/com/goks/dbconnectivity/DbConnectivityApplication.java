package com.goks.dbconnectivity;

import com.goks.dbconnectivity.Service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DbConnectivityApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbConnectivityApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(StudentService service){
        return  args -> {
            service.assignPassToExistingOnes("a@123");
        };
    }
}
