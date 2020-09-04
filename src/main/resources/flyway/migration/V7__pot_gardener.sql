create table pot_gardener
(
    id           uuid         not null primary key,
    name         varchar(50)  not null,
    app_user     uuid         not null,
    wifi_network varchar(255) not null,
    wifi_pass    varchar(255) not null,
    created_at   timestamp    not null,
    order_id     uuid         not null,
    constraint fk_pot_gardener_app_user foreign key (app_user) references app_user (id),
    constraint fk_pot_gardener_order_id foreign key (order_id) references gardener_order (id)
);

alter table specimen
    add constraint fk_specimen_pot_gardener foreign key (gardener)
        references pot_gardener(id);
