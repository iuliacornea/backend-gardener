create table growing_configuration (
    id                          uuid            not null        primary key,
    name                        varchar(120)    not null,
    soil_type                   varchar(50),
    soil_humidity_summer        smallint,
    soil_humidity_winter        smallint,
    air_humidity                smallint,
    air_temperature_summer      smallint,
    air_temperature_winter      smallint,
    light_intensity             smallint,
    watering_interval_days      smallint,
    app_user                    uuid
);
