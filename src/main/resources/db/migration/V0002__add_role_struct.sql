create table dectub_role
(
    id   bigint       not null,
    name varchar(200) not null
);

INSERT INTO dectub_role
VALUES (491997312445317120, 'admin');
INSERT INTO dectub_role
VALUES (491997312445317121, 'editor');
INSERT INTO dectub_role
VALUES (491997312445317122, 'user');

create table dectub_user_role
(
    id      bigint not null,
    user_id bigint not null,
    role_id bigint not null
);
