ALTER TABLE user
    ADD INDEX username_idx (username ASC) VISIBLE;
;


create table authorities
(
    username  varchar(50) not null,
    authority varchar(50) not null,
    INDEX `username_idx` (`username` ASC) VISIBLE,
    foreign key (username) references user (username)
);