create table specimen
(
    id                    uuid        not null primary key,
    plant_type            uuid,
    growing_configuration uuid,
    app_user              uuid        not null,
    name                  varchar(50) not null,
    season                varchar,
    created_at            timestamp   not null,
    gardener              uuid,
    constraint fk_specimen_plant_type foreign key (plant_type) references plant_type (id),
    constraint fk_specimen_growing_configuration foreign key (growing_configuration) references growing_configuration (id),
    constraint fk_specimen_user foreign key (app_user) references app_user (id)
);
