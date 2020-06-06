package com.codebrew.controllers;

import javax.validation.Valid;

import com.codebrew.models.Events;
import com.codebrew.models.UserEvent;
import com.codebrew.models.Users;
import com.codebrew.repository.UserEventRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javassist.NotFoundException;

@CrossOrigin("*")
@RestController
@RequestMapping("/userevent")
public class UserEventController {
    private Users user;
    private Events event;
    @Autowired
    UserEventRepo userEventRepo;

    @PutMapping("/attending")
    public UserEvent updateUserEvent(@PathVariable(value = "id") Long id,
            @Valid @RequestBody UserEvent uEDetails) throws NotFoundException {
       if (uEDetails == null) {
            return ((UserEvent) ((UserEvent) UserEvent.notFound()).header("Message", "no userEvent found with that Id"))
                    .build();
        }
         else {

            UserEvent userEvent = new UserEvent();

            userEvent.setUser(uEDetails.getUser(user));
            userEvent.setEvents(uEDetails.getEvent(event));

            userEventRepo.save(userEvent);
            System.out.println("attending updated");
            return userEvent;

        }
    }
}
  /*  }

        @DeleteMapping("/attending/delete/{id}") ResponseEntity<Events> deleteUserEventById(@PathVariable(value = "id") Integer id) {
            UserEvent foundUserEvent = UserEventRepo.findUserEventById(id);
    
            if (foundUserEvent == null) {
                return ResponseEntity.notFound().header("message", "UserEvent Not Found").build();
    
            } else {
                UserEventRepo.delete(foundUserEvent);
            }
            return ResponseEntity.ok().build();*/
        
         

        // @DeleteMapping("/attending/delete{id}")
        // UserEvent userEvent = new UserEvent();
        // userEvent.setId(id);
        // session.delete(userEvent);

    
