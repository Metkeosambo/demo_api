package com.example.app_api;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.app_api.dto.Product;
import com.example.app_api.dto.User;

@Configuration
@MappedTypes({User.class,Product.class})
@MapperScan("com.example.app_api.mapper")
@ComponentScan(basePackages = {"com.example.app_api"})
@SpringBootApplication
public class AppApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApiApplication.class, args);
	}

}
