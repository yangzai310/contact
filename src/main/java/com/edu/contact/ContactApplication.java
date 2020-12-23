package com.edu.contact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.edu.contact")
public class ContactApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactApplication.class, args);
    }



}
