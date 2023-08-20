create table ESTADO(
sigla varchar(2) not null,
nome varchar(30) not null,
primary key(sigla)
);

create table CIDADE(
cod_cidade int not null,
nome varchar(45) not null,
estado varchar(2),
primary key(cod_cidade),
foreign key(estado) references ESTADO(sigla)
);

create table DEPARTAMENTO(
cod_departamento int not null,
nome varchar(45) not null,
localizacao int not null,
cpf_gerente varchar(11),
primary key(cod_departamento),
foreign key(localizacao) references CIDADE(cod_cidade)
);

create table FUNCIONARIO(
cpf varchar(11) not null,
datanasc date not null,
nome varchar(45) not null,
endereco varchar(45) not null,
salario float not null,
sexo char not null,
cpf_supervisor varchar(11),
cod_departamento int not null,
primary key(cpf),
foreign key(cpf_supervisor) references FUNCIONARIO(cpf),
foreign key(cod_departamento) references DEPARTAMENTO(cod_departamento)
);

alter table DEPARTAMENTO add constraint `fk_cod_departamento`
foreign key(cpf_gerente) references FUNCIONARIO(cpf);

create table PROJETO(
cod_projeto int not null,
nome varchar(255) not null,
descricao varchar(255) not null,
cod_cidade int not null,
cod_departamento int not null,
primary key(cod_projeto),
foreign key(cod_cidade) references CIDADE(cod_cidade),
foreign key(cod_departamento) references DEPARTAMENTO(cod_departamento)
);

create table FUNCIONARIO_PROJETO(
cpf_funcionario varchar(11) not null,
cod_projeto int not null,
primary key(cpf_funcionario,cod_projeto),
foreign key(cpf_funcionario) references FUNCIONARIO(cpf),
foreign key(cod_projeto) references PROJETO(cod_projeto)
);