package dev.university.assignmenttracker.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "at")
public record AssignmentTrackerProperties(String welcomeMessage, String about) {

}
