create table app_user
(
    id       uuid         not null primary key,
    email    varchar(50) not null unique,
    password varchar not null,
    username varchar(50),
    role     varchar not null,
    token    varchar
);

alter table growing_configuration
    add constraint fk_growing_configuration_app_user
        foreign key (app_user) references app_user (id);

alter table plant_type
    add constraint fk_plant_type_app_user
        foreign key (app_user) references app_user (id);
