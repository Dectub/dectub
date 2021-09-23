create table dectub_system
(
    name  varchar(200) not null unique,
    value varchar(200) not null
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
VALUES ('register.email.content-prefix', '<h1>Welcome to ');
INSERT INTO dectub_system
VALUES ('register.email.content', '!</h1>
<h2>Click the button below to confirm email identity.</h2>
<h3>Warning: Please ignore this email unless you do it yourself!</h3>
<button type=\"button\">Verify</button>');
