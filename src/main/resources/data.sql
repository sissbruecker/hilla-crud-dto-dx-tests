INSERT INTO department (name)
VALUES ('IT'),
       ('HR');

INSERT INTO address (street, city)
VALUES ('12 Baker St', 'London'),
       ('2345 Park Ave', 'New York'),
       ('9/11 Kings Rd', 'Sydney'),
       ('888 Orchard Ln', 'Vancouver'),
       ('67 Shinjuku', 'Tokyo'),
       ('23 Quay St', 'Dublin'),
       ('4321 King Blvd', 'Toronto'),
       ('71 Beach Dr', 'Los Angeles'),
       ('222 Elm St', 'San Francisco'),
       ('56 River Rd', 'Paris');

INSERT INTO employee (name, email, address_id)
VALUES ('Alice', 'alice@initech.com', 1),
       ('Bob', 'bob@initech.com', 2),
       ('Charlie', 'charlie@initech.com', 3),
       ('David', 'david@initech.com', 4),
       ('Eve', 'eve@initech.com', 5),
       ('Frank', 'frank@initech.com', 6),
       ('Grace', 'grace@initech.com', 7),
       ('Hank', 'hank@initech.com', 8),
       ('Irene', 'irene@initech.com', 9),
       ('Jack', 'jack@initech.com', 10);

INSERT INTO employee_solution (name, email, address_id, department_id)
VALUES ('Alice', 'alice@initech.com', 1, 1),
       ('Bob', 'bob@initech.com', 2, 2),
       ('Charlie', 'charlie@initech.com', 3, 1),
       ('David', 'david@initech.com', 4, 2),
       ('Eve', 'eve@initech.com', 5, 1),
       ('Frank', 'frank@initech.com', 6, 2),
       ('Grace', 'grace@initech.com', 7, 1),
       ('Hank', 'hank@initech.com', 8, 2),
       ('Irene', 'irene@initech.com', 9, 1),
       ('Jack', 'jack@initech.com', 10, 2);
