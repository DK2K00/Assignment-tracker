package dev.university.assignmenttracker.repository;

import dev.university.assignmenttracker.model.Assignment;
import dev.university.assignmenttracker.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AssignmentRepository extends ListCrudRepository<Assignment, Integer> {
    List<Assignment> findAllByTitleContains(String keyword);

    @Query("""
                SELECT * FROM ASSIGNMENT
                WHERE status = :status
            """)
    List<Assignment> listByStatus(@Param("status") Status status);
}
