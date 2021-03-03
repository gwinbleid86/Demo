use demodb;

CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(45) NOT NULL,
    password VARCHAR(128) NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT 1,
    INDEX username_idx (username),
    PRIMARY KEY (id)
);

create table authorities(
    username  varchar(50) not null,
    authority varchar(50) not null,
    INDEX username_idx (username),
    foreign key (username) references users (username)
);

CREATE TABLE categories (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(45) NOT NULL,
    parent_id int null,
    PRIMARY KEY (id),
    INDEX parent_idx (id),
    FOREIGN KEY (parent_id) REFERENCES categories (id)
    ON DELETE set null
    ON UPDATE cascade
);

CREATE TABLE articles (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(45) NOT NULL,
    description VARCHAR(100) NULL,
    image_name varchar(100) null,
    image_original_name varchar(100) null,
    category_id INT NOT NULL,
    user_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (category_id) REFERENCES categories (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
