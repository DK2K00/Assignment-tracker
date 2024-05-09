package dev.university.assignmenttracker.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.university.assignmenttracker.model.Assignment;
import dev.university.assignmenttracker.repository.AssignmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final AssignmentRepository repository;
    private final ObjectMapper objectMapper;

    public DataLoader(AssignmentRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/assignment.json")) {
            repository.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<Assignment>>() {}));
        }
    }
}
