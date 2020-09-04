create table gardener_order
(
    id            uuid         not null primary key,
    app_user      uuid         not null,
    gardener_name varchar(50)  not null,
    wifi_network  varchar(255) not null,
    wifi_pass     varchar(255) not null,
    status        varchar(50)  not null,
    created_at    timestamp    not null,
    last_update   timestamp,
    constraint fk_gardener_order_app_user foreign key (app_user) references app_user (id)
);
