create table dectub_user
(
    id          bigint       not null,
    name        varchar(200) not null,
    email       varchar(200) not null unique,
    state       varchar(200) not null,
    password    varchar(200) not null,
    create_time date,
    update_time date
);
