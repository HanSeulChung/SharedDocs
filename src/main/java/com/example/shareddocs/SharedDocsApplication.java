package com.example.shareddocs;


import com.example.shareddocs.docs.entity.mongodb.Docs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = Docs.class)
public class SharedDocsApplication {
	public static void main(String[] args) {
		SpringApplication.run(SharedDocsApplication.class, args);
	}

}
