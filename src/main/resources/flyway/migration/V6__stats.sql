create table greenhouse_stats (
id                          uuid            not null            primary key,
user_email                  varchar(255)    not null,
air_temperature             int,
air_humidity                int,
soil_moisture               int,
photoresistance             int
);
