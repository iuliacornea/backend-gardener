create table app_user(
    id          uuid            not null primary key,
    email       varchar(255)    not null unique,
    password    varchar(255)    not null,
    username        varchar(255),
    role            varchar(255) not null,
    token       varchar(255)
);
