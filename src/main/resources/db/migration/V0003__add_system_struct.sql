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
VALUES ('register.email.content-prefix', '<p style="font-size: 3rem;font-weight: 600;line-height: 1.5em;color: rgb(0,0,0);">
        Welcome to #%website.name&%!
           </p >
           <p style="font-size: 2rem;font-weight: 500;line-height: .5em;color:rgba(0, 0, 0,.85);">
        Click the button below to confirm email identity.
           </p >
           <p style="font-size: 1rem;font-weight: 400;line-height: 0.5em;color:rgba(0, 0, 0, .65);">
        Warning: Please ignore this email unless you do it yourself!
           </p >
           <p style="margin-top: 1rem;"><br/>
           <a href="');
INSERT INTO dectub_system
VALUES ('register.email.content', '"
        style="padding: .5rem 1.5rem;border: 1px solid rgb(255,223,245);background: rgb(0, 234, 225);color: rgb(255,255,255);font-size: .8rem;font-weight: 600;cursor:pointer;">Verify</a>
           </p >');
