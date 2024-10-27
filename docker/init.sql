CREATE TABLE IF NOT EXISTS users
(
    id
    INT
    AUTO_INCREMENT
    PRIMARY
    KEY,
    username
    VARCHAR
(
    50
) NOT NULL,
    email VARCHAR
(
    100
) NOT NULL
    );

INSERT INTO users (username, email)
VALUES ('johndoe', 'johndoe@example.com'),
       ('janedoe', 'janedoe@example.com');

