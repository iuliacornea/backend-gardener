create table growing_configuration (
    id                          uuid            not null        primary key,
    soil_type                   varchar(255),
    soil_quantity               real,
    soil_humidity_summer        smallint,
    soil_humidity_winter        smallint,
    air_humidity                smallint,
    air_temperature_summer      real,
    air_temperature_winter      real,
    light_intensity_summer      real,
    light_intensity_winter      real
);