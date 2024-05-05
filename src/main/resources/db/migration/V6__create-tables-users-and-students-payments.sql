CREATE TABLE users_payments (
    id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES users(id),
    payment_id INTEGER REFERENCES payments(id)
);

CREATE TABLE students_payments (
    id SERIAL PRIMARY KEY,
    student_id INTEGER REFERENCES students(id),
    payment_id INTEGER REFERENCES payments(id)
);
