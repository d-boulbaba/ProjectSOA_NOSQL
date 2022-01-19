package com.pj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StudentStoreApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(StudentStoreApplication.class, args);
    }

}
