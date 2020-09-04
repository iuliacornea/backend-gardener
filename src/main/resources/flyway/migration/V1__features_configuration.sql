create table features_configuration(
    id                              uuid            not null        primary key,
    stem_type                       varchar(50),
    stem_spikes                     varchar(50),
    leaf_division_of_blade          varchar(50),
    leaf_arrangement_on_the_stem    varchar(50),
    leaf_surface                    varchar(50),
    leaf_texture                    varchar(50),
    leaf_vein_type                  varchar(50),
    flower_existance                varchar(50),
    flower_shape                    varchar(50),
    flower_petals                   varchar(50)
);
