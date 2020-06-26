package com;
import com.codebrew.models.Events;
import com.codebrew.models.Users;
//import com.codebrew.models.Events;
//import com.codebrew.models.Users;
// import com.codebrew.repository.EventsRepository;
// import com.codebrew.repository.UsersRepository;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.web.bind.annotation.PostMapping;

@ComponentScan(basePackages = { "com.codebrew.controllers", "com.codebrew.service", "com.codebrew.auth",
		"com.codebrew.models" })
@SpringBootApplication
public class Main implements CommandLineRunner  {
	


	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
	
		 Events event = new Events(null, null, null, null, null, null, null, 0, null, null, null);

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
