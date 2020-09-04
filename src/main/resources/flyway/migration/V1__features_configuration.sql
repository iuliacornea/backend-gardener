create table features_configuration(
    id                              uuid            not null        primary key,
    stem_type                       varchar,
    stem_spikes                     varchar,
    leaf_division_of_blade          varchar,
    leaf_arrangement_on_the_stem    varchar,
    leaf_surface                    varchar,
    leaf_texture                    varchar,
    leaf_vein_type                  varchar,
    flower_existance                varchar,
    flower_shape                    varchar,
    flower_petals                   varchar
);
