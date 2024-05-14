CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE users (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    first_name VARCHAR,
    last_name VARCHAR,
    date_of_birth DATE,
    document VARCHAR UNIQUE,
    email VARCHAR UNIQUE,
    password VARCHAR,
    user_type VARCHAR CHECK (user_type IN ('ADMIN', 'TEACHER')),
    active BOOLEAN
);

CREATE TABLE students (
     id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    first_name VARCHAR,
    last_name VARCHAR,
    gender VARCHAR CHECK (gender IN ('FEMALE', 'MALE')),
    phone VARCHAR,
    date_of_birth DATE,
    school_grade VARCHAR,
    active BOOLEAN
);

CREATE TABLE classes (
     id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    class_subject VARCHAR,
    class_type VARCHAR CHECK(class_type IN ('GROUP', 'PRIVATE')),
    class_date TIMESTAMP,
    class_content VARCHAR,
    teacher_id UUID REFERENCES users(id),
    student_id UUID REFERENCES students(id)
);

CREATE TABLE Payments (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    amount NUMERIC,
    payment_date TIMESTAMP,
    receiver_id UUID REFERENCES users(id),
    user_sender_id UUID REFERENCES users(id),
    student_sender_id UUID REFERENCES students(id)
);

CREATE TABLE users_payments (
   id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    user_id UUID REFERENCES users(id),
    payment_id UUID REFERENCES payments(id)
);

CREATE TABLE students_payments (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    student_id UUID REFERENCES students(id),
    payment_id UUID REFERENCES payments(id)
);
