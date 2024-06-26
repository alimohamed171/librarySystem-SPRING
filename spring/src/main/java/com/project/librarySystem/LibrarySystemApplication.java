package com.project.librarySystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class LibrarySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarySystemApplication.class, args);
	}


}
