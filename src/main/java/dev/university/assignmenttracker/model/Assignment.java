package dev.university.assignmenttracker.model;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record Assignment(Integer id,
                         @NotBlank
                         String title,
                         String subject,
                         Status status,
                         Type assignmentType,
                         LocalDateTime dateCreated,
                         LocalDateTime dueDate) {

}
