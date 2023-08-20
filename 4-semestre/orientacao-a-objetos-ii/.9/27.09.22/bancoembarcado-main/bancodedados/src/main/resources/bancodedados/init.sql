use app;

create table cliente
(
    id int not null auto_increment,
    nome varchar (255) not null,
    cpf varchar (11) not null,
    email varchar (100) not null,
    telefone varchar (10) not null,
    primary key (id)
);