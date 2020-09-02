create table features_configuration(
    id                              uuid            not null        primary key,
    stem_type                       varchar(255),
    stem_spikes                     varchar(255),
    leaf_division_of_blade          varchar(255),
    leaf_arrangement_on_the_stem    varchar(255),
    leaf_surface                    varchar(255),
    leaf_texture                    varchar(255),
    leaf_vein_type                  varchar(255),
    flower_existance                varchar(255),
    flower_shape                    varchar(255),
    flower_petals                   varchar(255),
    app_user                        uuid
);
