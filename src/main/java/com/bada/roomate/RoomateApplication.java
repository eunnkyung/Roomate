package com.bada.roomate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RoomateApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoomateApplication.class, args);
    }

}
