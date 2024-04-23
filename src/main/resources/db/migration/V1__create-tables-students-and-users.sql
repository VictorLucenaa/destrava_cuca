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

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL,
    user_type VARCHAR(10) NOT NULL,
    active BOOLEAN NOT NULL
);
