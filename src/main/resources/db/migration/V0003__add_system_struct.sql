create table dectub_system
(
    name  varchar(200) not null unique,
    value varchar(200) not null
);

INSERT INTO dectub_system
VALUES ('created', 'yes');
INSERT INTO dectub_system
VALUES ('register.email', 'off');
