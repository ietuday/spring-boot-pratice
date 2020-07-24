package com.uday.document;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DocumentwebApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(DocumentwebApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


