CREATE TABLE IF NOT EXISTS Assignment (
    id INTEGER AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    subject VARCHAR(255) NOT NULL,
    status VARCHAR(20) NOT NULL,
    assignment_type VARCHAR(20) NOT NULL,
    date_created TIMESTAMP NOT NULL,
    due_date TIMESTAMP,
    primary key(id)
);

INSERT INTO Assignment(title, subject, status, assignment_type, date_created)
VALUES('Normalisation Quiz', 'DBMS', 'IN_PROGRESS', 'QUIZ', CURRENT_TIMESTAMP)