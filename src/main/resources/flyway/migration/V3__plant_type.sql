create table plant_type
(
    id                     uuid        not null primary key,
    name                   varchar(50) not null,
    description            varchar,
    features_configuration uuid,
    growing_configuration  uuid,
    app_user               uuid,
    image                  varchar,
    constraint fk_plant_type_features_configuration foreign key (features_configuration) references features_configuration (id),
    constraint fk_plant_type_growing_configuration foreign key (growing_configuration) references growing_configuration (id)
);
