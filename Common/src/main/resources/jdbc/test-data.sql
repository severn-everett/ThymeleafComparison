INSERT INTO author(id, name)
VALUES (1, 'John Doe'),
       (2, 'Jane Doe');

INSERT INTO book(id, title, author_id)
VALUES (1, 'John''s First Book', 1),
       (2, 'Jane''s First Book', 2),
       (3, 'Jane''s Second Book', 2);
