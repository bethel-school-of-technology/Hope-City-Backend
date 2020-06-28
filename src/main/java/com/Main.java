package com;
import com.codebrew.models.Events;
import com.codebrew.models.Users;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = { "com.codebrew.controllers", "com.codebrew.service", "com.codebrew.auth",
		"com.codebrew.models" })
@SpringBootApplication
public class Main implements CommandLineRunner  {



	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {


		 // Create a Post
		 Events event = new Events();

 // Create two tags
 Users User1 = new Users();
 Users User2 = new Users();


 // Add  references in the post
 event.getEventName();
 event.getUsers();

 // Add post reference in the tags
 User1.getUsername();
 User2.getId();


		


		
	}

}
