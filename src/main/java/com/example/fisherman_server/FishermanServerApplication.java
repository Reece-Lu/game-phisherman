package com.example.fisherman_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FishermanServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FishermanServerApplication.class, args);
    }

}
