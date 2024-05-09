package dev.university.assignmenttracker.controller;

import dev.university.assignmenttracker.config.AssignmentTrackerProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {
/*
    @Value("${at.welcomeMessage: Default Welcome Message}")
    private String welcomeMessage;

    @Value("${at.about}")
    private String about;
*/
    private final AssignmentTrackerProperties properties;

    public HomeController(AssignmentTrackerProperties properties){
        this.properties = properties;
    }

    @GetMapping("/")
    public AssignmentTrackerProperties home(){
        return properties;
    }
}
