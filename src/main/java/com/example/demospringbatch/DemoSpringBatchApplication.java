package com.example.demospringbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class DemoSpringBatchApplication {

	public static void main(String[] args) {
		SpringApplication springApp = new SpringApplication(DemoSpringBatchApplication.class);
		springApp.setAdditionalProfiles("spring-boot");
		springApp.run(args);
	}

}
