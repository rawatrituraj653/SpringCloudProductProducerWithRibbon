package com.shivam.motors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudProductProducerWithRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudProductProducerWithRibbonApplication.class, args);
	}

}
