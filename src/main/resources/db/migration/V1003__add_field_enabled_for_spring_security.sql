use demodb;

ALTER TABLE user
    ADD COLUMN enabled BOOLEAN NOT NULL DEFAULT 1 AFTER passw;
