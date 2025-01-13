CREATE TABLE respuestas (
id bigint not null auto_increment,
mensaje varchar (2500) not null,
fechaCreacion timestamp not null,
autor varchar (100),

primary key (id)

);