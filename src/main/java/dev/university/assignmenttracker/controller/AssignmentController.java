package dev.university.assignmenttracker.controller;

import dev.university.assignmenttracker.model.Assignment;
import dev.university.assignmenttracker.repository.AssignmentCollectionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assignment")
@CrossOrigin
public class AssignmentController {

    private final AssignmentCollectionRepository repository;

    public AssignmentController(AssignmentCollectionRepository repository) {
        this.repository = repository;
    }

    //READ
    @GetMapping("")
    public List<Assignment> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Assignment findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Assignment Not Found"));
    }

    //
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Assignment assignment){
        repository.create(assignment);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void save(@RequestBody Assignment assignment){
        repository.save(assignment);
    }

    //UPDATE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Assignment assignment, @PathVariable Integer id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Assignment Not Found!");
        }
        repository.save(assignment);
    }

    //DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        repository.delete(id);
    } 
}


