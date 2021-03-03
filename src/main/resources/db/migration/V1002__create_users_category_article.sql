use demodb;

INSERT INTO users (username, password)
VALUES ('admin', '$2a$10$Qv3hLl8B7y1bzA356h7FweOW8XQ8plGieprOn/yc85prj4ozXWCvm'),
       ('user', '$2a$10$AyykyS/qB6dPOiuWJqD0nuxaqUGltbk5GDhbXMBLTx/jzigSCChGm');

insert into categories (title)
values ('common_topic'),
       ('test_category'),
       ('another_test_category');

insert into categories (title, parent_id)
values ('test_sub_category', 1);
