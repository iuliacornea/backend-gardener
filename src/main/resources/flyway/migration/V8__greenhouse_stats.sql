create table greenhouse_stats
(
    id                       uuid not null primary key,
    gardener                 uuid not null,
    specimen                 uuid not null,
    air_temperature_raw      int,
    air_humidity_raw         int,
    soil_moisture_raw        int,
    soil_moisture_percentage int,
    photoresistance_raw      int,
    photoresistance_lux      int,
    received_at              timestamp,
    constraint fk_greenhouse_stats_pot_gardener foreign key (gardener) references pot_gardener (id),
    constraint fk_greenhouse_stats_specimen foreign key (specimen) references specimen (id)
);
