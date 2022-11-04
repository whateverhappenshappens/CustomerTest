package com.example.demo.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.CommandLinePropertySource;
@Configuration
public class CustomerConfig {
    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            System.out.println("command line runner");
        };
    }
}