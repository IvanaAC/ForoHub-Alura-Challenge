CREATE TABLE topico (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    message TEXT NOT NULL,
    course_name VARCHAR(150) NOT NULL,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

