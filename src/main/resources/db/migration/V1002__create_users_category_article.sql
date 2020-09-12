use demodb;

INSERT INTO user (username, passw)
VALUES ('admin', 'admin'),
       ('user', 'user');

insert into category (title)
values ('test_category'),
       ('another_test_category');

insert into category (title, parent_id)
values ('test_sub_category', 1);
