create table plant_type
(
    id                     uuid         not null primary key,
    name                   varchar(255) not null,
    description            varchar(1023),
    features_configuration uuid         not null,
    growing_configuration  uuid         not null,
    app_user               uuid,
    image                  varchar(511),
    constraint fk_plant_type_features_configuration foreign key (features_configuration) references features_configuration (id),
    constraint fk_plant_type_growing_configuration foreign key (growing_configuration) references growing_configuration (id)
);
