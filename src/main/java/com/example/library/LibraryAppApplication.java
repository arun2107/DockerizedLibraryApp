package com.example.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.library")
public class LibraryAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(LibraryAppApplication.class, args);
    }
}