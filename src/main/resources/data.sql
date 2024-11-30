CREATE TABLE book (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    isbn VARCHAR(50) NOT NULL
);

INSERT INTO book (title, author, isbn) VALUES 
    ('Effective Java', 'Joshua Bloch', '978-0134685991'),
    ('Clean Code', 'Robert C. Martin', '978-0132350884'),
    ('Spring Boot in Action', 'Craig Walls', '978-1617292545');