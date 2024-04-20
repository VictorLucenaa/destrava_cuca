CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    middle_name VARCHAR(255),
    gender VARCHAR(50) NOT NULL,
    phone VARCHAR(20),
    date_of_birth DATE,
    school_grade VARCHAR(50),
    active BOOLEAN NOT NULL
);
