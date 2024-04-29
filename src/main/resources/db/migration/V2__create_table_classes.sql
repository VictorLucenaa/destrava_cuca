CREATE TABLE classes (
    id SERIAL PRIMARY KEY,
    class_subject VARCHAR,
    class_type VARCHAR CHECK(class_type IN ('GROUP', 'PRIVATE')),
    class_date TIMESTAMP,
    teacher_id INTEGER REFERENCES users(id),
    student_id INTEGER REFERENCES students(id)
);


