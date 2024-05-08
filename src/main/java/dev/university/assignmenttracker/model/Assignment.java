package dev.university.assignmenttracker.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record Assignment(
                         @Id
                         Integer id,
                         @NotBlank
                         String title,
                         String subject,
                         Status status,
                         Type assignmentType,
                         LocalDateTime dateCreated,
                         LocalDateTime dueDate) {

}
