package com.codebrew.controllers;

import javax.validation.Valid;

import com.codebrew.models.UserEvent;
import com.codebrew.repository.UserEventRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    @Autowired
    UserEventRepo userEventRepo;

    @PutMapping("/attending")
    public ResponseEntity<UserEvent> updateUserEvent(@PathVariable(value = "id") Long id,
            @Valid @RequestBody UserEvent uEDetails) throws NotFoundException {
        if (uEDetails == null) {
            return ResponseEntity.notFound().header("Message", "no user found with that Id").build();
        } else {

            UserEvent userEvent = new UserEvent();

            userEvent.setUser(uEDetails.getUser(user);
            userEvent.setEvent(uEDetails.getEvent(event));

            final UserEvent updatedAttending = userEventRepo.save(userEvent);
            System.out.println("attending updated");
            return ResponseEntity.ok().build();

        }

        // @DeleteMapping("/attending/delete{id}")
        // UserEvent userEvent = new UserEvent();
        // userEvent.setId(id);
        // session.delete(userEvent);

    }
}