use demodb;

alter table articles add column date DATETIME DEFAULT CURRENT_TIMESTAMP;