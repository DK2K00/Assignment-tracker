package dev.university.assignmenttracker.repository;

import dev.university.assignmenttracker.model.Assignment;
import dev.university.assignmenttracker.model.Status;
import dev.university.assignmenttracker.model.Type;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class AssignmentJdbcTemplateRepository {

    private final JdbcTemplate jdbcTemplate;

    public AssignmentJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static Assignment mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Assignment(rs.getInt("id"),
                rs.getString("title"),
                rs.getString("subject"),
                Status.valueOf(rs.getString("status")),
                Type.valueOf(rs.getString("assignment_type")),
                rs.getObject("date_created", LocalDateTime.class),
                rs.getObject("due_date",LocalDateTime.class)
                );
    }

    public List<Assignment> getAllAssignment() {
        String sql = "SELECT * FROM ASSIGNMENT";
        List<Assignment> assignments = jdbcTemplate.query(sql, AssignmentJdbcTemplateRepository::mapRow);
        return assignments;
    }

    public void createAssignment(String title, String subject, Status status, Type assignmentType) {
        String sql = "INSERT INTO ASSIGNMENT (title, subject, status, assignment_type, date_created) VALUES (?, ?, ?, ?, NOW())";
        jdbcTemplate.update(sql, title, subject, status, assignmentType);
    }

    public void updateAssignment(int id, String title, String subject, Status status, Type assignmentType) {
        String sql = "UPDATE ASSIGNMENT SET title=?, subject=?, status=?, assignment_type=?, date_updated=NOW(), WHERE id=?";
        jdbcTemplate.update(sql, title, subject, status, assignmentType, id);
    }

    public void deleteAssignment(int id) {
        String sql = "DELETE FROM ASSIGNMENT WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public Assignment getAssignment(int id) {
        String sql = "SELECT * FROM ASSIGNMENT WHERE id=?";
        Assignment assignment = jdbcTemplate.queryForObject(sql, new Object[]{id}, AssignmentJdbcTemplateRepository::mapRow);
        return assignment;
    }
}