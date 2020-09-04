create table growing_configuration
(
    id                         uuid        not null primary key,
    name                       varchar(50) not null,
    soil_moisture_summer_min   smallint,
    soil_moisture_summer_max   smallint,
    soil_moisture_winter_min   smallint,
    soil_moisture_winter_max   smallint,
    air_humidity_min           smallint,
    air_humidity_max           smallint,
    air_temperature_summer_min smallint,
    air_temperature_summer_max smallint,
    air_temperature_winter_min smallint,
    air_temperature_winter_max smallint,
    light_intensity_min        smallint,
    light_intensity_max        smallint,
    watering_interval_days     smallint,
    app_user                   uuid
);
