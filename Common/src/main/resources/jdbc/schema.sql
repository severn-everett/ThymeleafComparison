CREATE TABLE author(
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE book(
    id INT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author_id INT,
    FOREIGN KEY (author_id) REFERENCES author(id) ON DELETE CASCADE
);
