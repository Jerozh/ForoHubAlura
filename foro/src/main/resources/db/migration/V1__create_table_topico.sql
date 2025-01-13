create table topico (
id bigint not null auto_increment,
titulo varchar(100) not null,
mensaje varchar(2000) not null,
fechaCreacion timestamp not null,
status tinyint not null,
autor varchar(100) not null,
curso varchar(100) not null,
respuestas varchar(2000),

primary key(id)
);
