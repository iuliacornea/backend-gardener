create table specimen (
    id          uuid            not null            primary key,
    plant_type  uuid            not null,
    app_user        uuid            not null,
    name        varchar(255)    not null,
    size        varchar(255),
    season      varchar(255),
    constraint fk_plant_type foreign key (plant_type) references plant_type(id),
    constraint fk_user foreign key (app_user) references app_user(id)
);