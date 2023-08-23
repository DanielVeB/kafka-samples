package com.kurosz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SubApplication {


    public static void main(String[] args) {
        SpringApplication.run(SubApplication.class, args);
    }

}
