package dev.university.assignmenttracker.repository;

import dev.university.assignmenttracker.model.Assignment;
import dev.university.assignmenttracker.model.Status;
import dev.university.assignmenttracker.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//To keep assignments in memory while I work on them
@Repository
public class AssignmentCollectionRepository {

    private final List<Assignment> assignmentList = new ArrayList<>();

    public AssignmentCollectionRepository(){

    }

    public List<Assignment> findAll(){
        return assignmentList;
    }

    //To deal with NullPointerExceptions
    public Optional<Assignment> findById(Integer id){
        return assignmentList.stream().filter(a -> a.id().equals(id)).findFirst();
    }

    public void save(Assignment assignment){
        assignmentList.removeIf(a -> a.id().equals(assignment.id()));
        assignmentList.add(assignment);
    }

    @PostConstruct
    private void init(){
        Assignment a = new Assignment(1, "DBMS Quiz","Database", Status.IN_PROGRESS, Type.QUIZ, LocalDateTime.now(), null);

        assignmentList.add(a);
    }

    public boolean existsById(Integer id){
        return assignmentList.stream().filter(a -> a.id().equals(id)).count() == 1;
    }

    public void delete(Integer id){
        assignmentList.removeIf(a -> a.id().equals(id));
    }
}
