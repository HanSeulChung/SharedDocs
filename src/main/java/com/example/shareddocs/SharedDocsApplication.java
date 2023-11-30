package com.example.shareddocs;


import com.example.shareddocs.docs.entity.mongodb.Docs;
import com.example.shareddocs.docs.entity.mysql.DocumentsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableJpaAuditing
@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = DocumentsRepository.class)
@EnableMongoRepositories(basePackageClasses = Docs.class)
public class SharedDocsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SharedDocsApplication.class, args);
	}

}
