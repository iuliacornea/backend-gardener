create table growing_configuration (
    id                          uuid            not null        primary key,
    soil_type                   varchar(255),
    soil_quantity               smallint,
    soil_humidity_summer        varchar(255),
    soil_humidity_winter        varchar(255),
    air_humidity                varchar(255),
    air_temperature_summer      smallint,
    air_temperature_winter      smallint,
    light_intensity_summer      varchar(255),
    light_intensity_winter      varchar(255),
    app_user                    uuid
);
