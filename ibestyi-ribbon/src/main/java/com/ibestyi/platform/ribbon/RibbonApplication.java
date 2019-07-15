package com.ibestyi.platform.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RibbonClient(name = "ibestyi-ribbon", configuration = RibbonConfiguration.class)
public class RibbonApplication {

	@LoadBalanced
	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/")
	public String index() {
		return this.restTemplate.getForObject("http://ibestyi-gateway", String.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(RibbonApplication.class, args);
	}
}
