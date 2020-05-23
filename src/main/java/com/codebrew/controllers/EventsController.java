package com.codebrew.controllers;

import java.util.ArrayList;
import java.util.List;

import com.codebrew.models.Events;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/events")
public class EventsController {
    
   @GetMapping()
   public String getAllEvents(Model model) {
       List<Events> events = new ArrayList<Events> ();  
    model.addAttribute("events", events);
    return "events";
    }

}