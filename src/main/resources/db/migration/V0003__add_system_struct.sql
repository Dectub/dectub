create table dectub_system
(
    name  varchar(200) not null unique,
    value text
);

INSERT INTO dectub_system
VALUES ('created', 'yes');
INSERT INTO dectub_system
VALUES ('register.email', 'off');
INSERT INTO dectub_system
VALUES ('register.email.host', '');
INSERT INTO dectub_system
VALUES ('register.email.port', '');
INSERT INTO dectub_system
VALUES ('register.email.username', '');
INSERT INTO dectub_system
VALUES ('register.email.password', '');
INSERT INTO dectub_system
VALUES ('register.email.default-encoding', '');
INSERT INTO dectub_system
VALUES ('website.name', 'Dectub');
INSERT INTO dectub_system
VALUES ('register.email.name', 'Dectub');
INSERT INTO dectub_system
VALUES ('register.email.title', 'Confirm your account now');
INSERT INTO dectub_system
VALUES ('register.email.content', 'Welcome to #%website.name&%!');
