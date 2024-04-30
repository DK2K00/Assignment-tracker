package dev.university.assignmenttracker.model;

import java.time.LocalDateTime;

public record Assignment(Integer id,
                         String title,
                         String subject,
                         Status status,
                         Type assignmentType,
                         LocalDateTime dateCreated,
                         LocalDateTime dueDate) {

}
