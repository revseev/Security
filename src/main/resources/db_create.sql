-- Table: users
CREATE TABLE users(
                    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                    username VARCHAR(255) NOT NULL  UNIQUE ,
                    password VARCHAR(255) NOT NULL ,
                    money BIGINT
) ENGINE = InnoDB;
-- Table: roles
CREATE TABLE roles(
                    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(255) NOT NULL

) ENGINE = InnoDB;
-- Join Table: users_roles
CREATE TABLE users_roles(
                    user_id BIGINT NOT NULL,
                    role_id BIGINT NOT NULL,

                    FOREIGN KEY (user_id) REFERENCES users(id),
                    FOREIGN KEY (role_id) REFERENCES roles(id),

                    UNIQUE (user_id, role_id)
) ENGINE = InnoDB;

-- Populate Table:
INSERT INTO users VALUES (1, 'a', 'a', 999);
INSERT INTO roles VALUES (1, 'USER'), (2, 'ADMIN');
INSERT INTO users_roles VALUES (1, 1), (1, 2);