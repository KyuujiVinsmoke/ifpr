create table biblioteca_funcionario
(
    codigo_funcionario INT NOT NULL AUTO_INCREMENT,
    nome_funcionario VARCHAR(255) NOT NULL,
    endereco_funcionario VARCHAR(255) NOT NULL,
    login VARCHAR(100) NOT NULL,
    funcao VARCHAR(45) NOT NULL,
    senha VARCHAR(255),
    PRIMARY KEY (codigo_funcionario)
);

create table biblioteca_acervo
(
    codigo_acervo INT NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    tipo VARCHAR(45) NOT NULL,
    status VARCHAR(45) NOT NULL,
    PRIMARY KEY (codigo_acervo)
);

create table biblioteca_usuario
(
    registro_academico INT NOT NULL AUTO_INCREMENT,
    nome_usuario VARCHAR(255) NOT NULL,
    endereco_usuario VARCHAR(255) NULL,
    login VARCHAR(45),
    bloqueio_ativo BIT,
    data_limite_bloqueio DATE NOT NULL,
    numero_emprestimos_ativos SMALLINT (10),
    PRIMARY KEY (registro_academico)
);

create table biblioteca_telefone_usuario
(
    telefone_usuario VARCHAR(15) NOT NULL,
    registro_academico INT NOT NULL,
    PRIMARY KEY (telefone_usuario),
    FOREIGN KEY (registro_academico) REFERENCES biblioteca_usuario (registro_academico)
);

create table biblioteca_telefone_funcionario
(
    telefone_funcionario VARCHAR(15) NOT NULL,
    codigo_funcionario INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (telefone_funcionario),
    FOREIGN KEY (codigo_funcionario) REFERENCES biblioteca_funcionario (codigo_funcionario)
);

create table biblioteca_reserva
(
    data_reserva DATE NOT NULL,
    data_limite_reserva DATE NOT NULL,
    status_limite_reserva DATE NOT NULL,
    registro_academico INT NOT NULL,
    codigo_acervo INT NOT NULL,
    FOREIGN KEY (registro_academico) REFERENCES biblioteca_usuario (registro_academico),
    FOREIGN KEY (codigo_acervo) REFERENCES biblioteca_acervo (codigo_acervo)
);

create table biblioteca_emprestar
(
    data_devolucao DATE NULL,
    numero_renovacao SMALLINT(10) NOT NULL,
    data_emprestimo DATE NOT NULL,
    data_prevista_devolucao DATE NOT NULL,
    registro_academico INT NOT NULL,
    codigo_funcionario INT NOT NULL AUTO_INCREMENT,
    codigo_acervo INT NOT NULL,
    FOREIGN KEY (registro_academico) REFERENCES biblioteca_usuario (registro_academico),
    FOREIGN KEY (codigo_funcionario) REFERENCES biblioteca_funcionario (codigo_funcionario),
    FOREIGN KEY (codigo_acervo) REFERENCES biblioteca_acervo (codigo_acervo)
);