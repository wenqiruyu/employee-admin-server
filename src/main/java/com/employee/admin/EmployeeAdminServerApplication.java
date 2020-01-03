package com.employee.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling // 开启定时任务
@SpringBootApplication
public class EmployeeAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAdminServerApplication.class, args);
	}

}
