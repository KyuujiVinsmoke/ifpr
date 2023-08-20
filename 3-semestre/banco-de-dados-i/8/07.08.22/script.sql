create table agenda_estado
(
    cod_estado INT NOT NULL AUTO_INCREMENT,
    estado VARCHAR(50) NOT NULL,
    PRIMARY KEY (cod_estado)
);

create table agenda_cidade
(
    cod_cidade INT NOT NULL AUTO_INCREMENT,
    cidade VARCHAR(50) NOT NULL,
    cod_estado INT NOT NULL,
    PRIMARY KEY (cod_cidade),
    FOREIGN KEY (cod_estado) REFERENCES agenda_estado(cod_estado)
);

create table agenda_endereco
(
    cod_endereco INT NOT NULL AUTO_INCREMENT,
    rua VARCHAR(150) NOT NULL,
    bairro VARCHAR(50) NOT NULL,
    cep VARCHAR(15) NOT NULL,
    cod_cidade INT NOT NULL,
    PRIMARY KEY(cod_endereco),
    FOREIGN KEY(cod_cidade) REFERENCES agenda_cidade(cod_cidade)
);

create table agenda_pessoa
(
    cod_pessoa INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(200) NOT NULL,
    data_nascimento DATE NOT NULL,
    PRIMARY KEY(cod_pessoa)
);

create table agenda_pessoa_endereco
(
    cod_pessoa INT NOT NULL,
    cod_endereco INT NOT NULL,
    numero INT NOT NULL,
    PRIMARY KEY (cod_pessoa, cod_endereco),
    FOREIGN KEY (cod_pessoa) REFERENCES agenda_pessoa(cod_pessoa),
    FOREIGN KEY (cod_endereco) REFERENCES agenda_endereco(cod_endereco)
);

create table agenda_email
(
    cod_pessoa INT NOT NULL,
    email VARCHAR(30),
    PRIMARY KEY(email),
    FOREIGN KEY (cod_pessoa) REFERENCES agenda_pessoa(cod_pessoa)
);

create table agenda_telefone
(
    cod_pessoa INT NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    PRIMARY KEY (cod_pessoa, telefone),
    FOREIGN KEY(cod_pessoa) REFERENCES agenda_pessoa(cod_pessoa)
);