package com.example.subscriber1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Subscriber1Application {

    public static void main(String[] args) {
        SpringApplication.run(Subscriber1Application.class, args);
    }

}
