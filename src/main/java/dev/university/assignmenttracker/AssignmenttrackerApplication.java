package dev.university.assignmenttracker;

import dev.university.assignmenttracker.model.Assignment;
import dev.university.assignmenttracker.model.Status;
import dev.university.assignmenttracker.model.Type;
import dev.university.assignmenttracker.repository.AssignmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class AssignmenttrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmenttrackerApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AssignmentRepository repository){
		return args -> {
			//Insert some data into database
			Assignment assignment = new Assignment(null, "Neural Networks Assignment","AI", Status.COMPLETED, Type.PROGRAMMING, LocalDateTime.now(), null);
			repository.save(assignment);
		};
	}
}
