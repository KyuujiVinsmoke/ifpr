create table mecanica_proprietario(
    proprietario_cpf int not null,
    proprietario_nome varchar(255) not null,
    endereco varchar(255) not null,
    primary key(proprietario_cpf)
);

create table mecanica_telefone(
    proprietario_cpf int not null,
    proprietario_telefone int not null,
    primary key(proprietario_telefone, proprietario_cpf),
    foreign key(proprietario_cpf) REFERENCES mecanica_proprietario(proprietario_cpf)
);

create table mecanica_marca(
    marca_codigo int not null AUTO_INCREMENT,
    descricao varchar(45) not null,
    primary key(marca_codigo)
);

create table mecanica_modelo(
    modelo_codigo int not null AUTO_INCREMENT,
    marca_codigo int not null,
    modelo_descricao varchar(45),
    primary key(modelo_codigo),
    foreign key(marca_codigo) REFERENCES mecanica_marca (marca_codigo)
);

create table mecanica_mao_de_obra(
    codigo_mao_de_obra int not null AUTO_INCREMENT,
    mao_de_obra_descricao varchar(45) not null,
    mao_de_obra_valor float not null,
    primary key(codigo_mao_de_obra)
);

create table mecanica_pecas(
    codigo_pecas int not null AUTO_INCREMENT,
    descricao_pecas varchar(45) not null,
    valor_pecas float not null,
    quantidade_pecas int not null,
    primary key(codigo_pecas)
);

create table mecanica_veiculo(
    veiculo_placa varchar(7) not null,
    proprietario_cpf int not null,
    modelo_codigo int not null,
    veiculo_ano int not null,
    veiculo_cor varchar(45) not null,
    veiculo_data_cadastro date not null,
    historico text not null,
    primary key(veiculo_placa),
    foreign key(proprietario_cpf) REFERENCES mecanica_proprietario(proprietario_cpf),
    foreign key(modelo_codigo) REFERENCES mecanica_modelo(modelo_codigo)
);

create table mecanica_avarias(
    avarias_codigo int not null AUTO_INCREMENT,
    veiculo_placa varchar(7) not null,
    avarias varchar(255) not null,
    primary key(avarias_codigo),
    foreign key(veiculo_placa) REFERENCES mecanica_veiculo(veiculo_placa)
);

create table mecanica_ordem_de_servico(
    ordem_codigo int not null AUTO_INCREMENT,
    veiculo_placa varchar(7) not null,
    ordem_data date not null,
    ordem_data_validate date not null,
    ordem_valor float not null,
    ordem_servico bit null,
    ordem_data_prevista date null,
    ordem_data_finalizacao date null,
    ordem_diagnostico varchar(255) not null,
    primary key(ordem_codigo),
    foreign key(veiculo_placa) REFERENCES mecanica_veiculo(veiculo_placa)
);

create table mecanica_utiliza_pecas(
    codigo_pecas int not null,
    ordem_codigo int not null,
    utliza_quantidade int not null,
    valor float not null,
    primary key(codigo_pecas, ordem_codigo),
    foreign key(codigo_pecas) REFERENCES mecanica_pecas(codigo_pecas),
    foreign key(ordem_codigo) REFERENCES mecanica_ordem_de_servico(ordem_codigo)
);

create table mecanica_utiliza_mao_de_obra(
    codigo_mao_de_obra int not null,
    ordem_servico int not null,
    valor float not null,
    quantidade int not null,
    primary key(codigo_mao_de_obra, ordem_servico),
    foreign key(codigo_mao_de_obra) REFERENCES mecanica_mao_de_obra(codigo_mao_de_obra),
    foreign key(ordem_servico) REFERENCES mecanica_ordem_de_servico(ordem_codigo)
);