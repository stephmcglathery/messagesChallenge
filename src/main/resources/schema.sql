DROP TABLE IF EXISTS messages;

create table messages (
    message  varchar(100)    not null,
    hash   varchar(256)    not null
);