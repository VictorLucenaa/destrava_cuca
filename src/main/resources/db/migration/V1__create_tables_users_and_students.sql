CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR,
    last_name VARCHAR,
    document VARCHAR UNIQUE,
    email VARCHAR UNIQUE,
    password VARCHAR,
    user_type VARCHAR CHECK (user_type IN ('ADMIN', 'TEACHER')),
    active BOOLEAN
);

CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR,
    last_name VARCHAR,
    gender VARCHAR CHECK (gender IN ('FEMALE', 'MALE')),
    phone VARCHAR,
    date_of_birth DATE,
    school_grade VARCHAR,
    active BOOLEAN
);