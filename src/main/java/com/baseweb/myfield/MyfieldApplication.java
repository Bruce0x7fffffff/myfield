package com.baseweb.myfield;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baseweb.myfield.mybatisdemo.mapper")
public class MyfieldApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyfieldApplication.class, args);
	}
}
