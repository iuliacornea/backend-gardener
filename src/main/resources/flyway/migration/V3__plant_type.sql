create table plant_type(
    id                          uuid            not null primary key,
    features_configuration      uuid            not null,
    growing_configuration       uuid            not null,
    name                        varchar(255)    not null,
    description                 varchar(255),
    image                       bytea                     
);