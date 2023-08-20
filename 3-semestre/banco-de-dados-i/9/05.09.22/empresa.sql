create table empresa_estado
(
	sigla_estado varchar (2) not null,
	nome_estado varchar (30) not null,
	primary key (sigla_estado)
);

create table empresa_cidade
(
	codigo_cidade INT NOT NULL AUTO_INCREMENT,
	nome_cidade VARCHAR (45) NOT NULL,
	sigla_estado varchar (2) NOT NULL,
	primary key (codigo_cidade),
	foreign key (sigla_estado) REFERENCES empresa_estado (sigla_estado)
);

create table empresa_departamento
(
	codigo_departamento int not null AUTO_INCREMENT,
	nome_departamento VARCHAR (45) NOT NULL,
	cpf_gerente_departamento VARCHAR (11) null,
	codigo_cidade INT NOT NULL,
	primary key (codigo_departamento),
	foreign key (codigo_cidade) REFERENCES empresa_cidade (codigo_cidade)
);

create table empresa_projeto
(
	codigo_projeto int not null AUTO_INCREMENT,
	nome_projeto varchar (45) not null,
	descricao_projeto varchar (255) not null,
	codigo_cidade int not null,
	codigo_departamento int not null,
	primary key (codigo_projeto),
	foreign key (codigo_cidade) REFERENCES empresa_cidade (codigo_cidade),
	foreign key (codigo_departamento) REFERENCES empresa_departamento (codigo_departamento)
);

create table empresa_funcionario
(
	cpf_funcionario VARCHAR (11) not null,
	datanasc_funcionario date not null,
	nome_funcionario VARCHAR (45) not null,
	endereco_funcionario VARCHAR (45) not NULL,
	salario_funcionario FLOAT NOT NULL,
	sexo_funcionario CHAR not null,
	cpf_supervisor_funcionario VARCHAR (11) null,
	codigo_departamento int not null,
	primary key (cpf_funcionario),
	foreign key (codigo_departamento) REFERENCES empresa_departamento (codigo_departamento)
);

create table empresa_funcionario_projeto
(
	cpf_funcionario VARCHAR (11) not null,
	codigo_projeto int not null,
	foreign key (cpf_funcionario) REFERENCES empresa_funcionario (cpf_funcionario),
    foreign key (codigo_projeto) REFERENCES empresa_projeto (codigo_projeto)
);

drop table empresa_projeto, empresa_funcionario_projeto, empresa_funcionario, empresa_estado, empresa_departamento, empresa_cidade