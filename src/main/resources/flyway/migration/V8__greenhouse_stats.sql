create table greenhouse_stats
(
    id                       uuid not null primary key,
    app_user                 uuid not null ,
    gardener                 uuid not null,
    specimen                 uuid,
    air_temperature_raw      int,
    air_temperature_celsius  int,
    air_humidity_raw         int,
    air_humidity_percentage  int,
    soil_moisture_raw        int,
    soil_moisture_percentage int,
    light_intensity_raw      int,
    light_intensity_lux      int,
    received_at              timestamp,
    constraint fk_greenhouse_stats_app_user foreign key (app_user) references app_user (id),
    constraint fk_greenhouse_stats_pot_gardener foreign key (gardener) references pot_gardener (id),
    constraint fk_greenhouse_stats_specimen foreign key (specimen) references specimen (id)
);
