use demodb;

CREATE TABLE user (
  id INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(45) NOT NULL,
  passw VARCHAR(45) NOT NULL,
  PRIMARY KEY (id)
  );

  CREATE TABLE category (
  id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(45) NOT NULL,
  parent_id int null,
  PRIMARY KEY (id),
  INDEX parent_idx (id),
  CONSTRAINT FK_id
  FOREIGN KEY (parent_id)
  REFERENCES category (id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION);

CREATE TABLE article (
  id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(45) NOT NULL,
  description VARCHAR(100) NULL,
  image VARCHAR(45) NULL,
  category_id INT NOT NULL,
  user_id INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_user_id
    FOREIGN KEY (user_id)
    REFERENCES user (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT FK_category_id
    FOREIGN KEY (category_id)
    REFERENCES category (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
