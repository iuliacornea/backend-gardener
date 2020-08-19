create table app_user(
    id          uuid            not null primary key,
    email       varchar(255)    not null,
    name        varchar(255)
);