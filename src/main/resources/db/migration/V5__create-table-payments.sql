CREATE TABLE Payments (
    id SERIAL PRIMARY KEY,
    amount NUMERIC,
    payment_date TIMESTAMP,
    receiver_id INTEGER REFERENCES users(id),
    user_sender_id INTEGER REFERENCES users(id),
    student_sender_id INTEGER REFERENCES students(id)
);