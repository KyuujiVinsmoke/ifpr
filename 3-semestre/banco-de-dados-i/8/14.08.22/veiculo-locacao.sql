create table locadora_veiculos_locadora
(
	cnpj_locadora varchar (20) not null,
	razao_social_locadora varchar (100),
	endereco_locadora varchar (255),
	primary key (cnpj_locadora)
);

create table locadora_veiculos_telefone
(
	telefone_telefone varchar (20) not null,
	cnpj_locadora varchar (20) not null,
	primary key (telefone_telefone),
	foreign key (cnpj_locadora) REFERENCES locadora_veiculos_locadora (cnpj_locadora) 
);

create table locadora_veiculos_tipo_veiculo
(
	codigo_tipo_veiculo int not null AUTO_INCREMENT,
	descricao_tipo_veiculo varchar (255) not null,
	porte_tipo_veiculo varchar (45) not null,
	tamanho_tipo_veiculo varchar (45) null,
	numero_passageiros_tipo_veiculo int null,
	numero_portas_tipo_veiculo int null,
	arcondicionado_tipo_veiculo Bit null,
	multimidia_tipo_veiculo Bit null,
	direcao_hidraulica_tipo_veiculo Bit null,
	cambio_automatico_tipo_veiculo Bit null,
	capacidade_carga_tipo_veiculo Bit null,
	primary key (codigo_tipo_veiculo)
);

create table locadora_veiculos_marca
(
	codigo_marca int not null AUTO_INCREMENT,
	descricao_marca varchar (100),
	primary key (codigo_marca)
);

create table locadora_veiculos_modelo
(
	codigo_modelo int not null AUTO_INCREMENT,
	descricao_modelo varchar (255) not null,
	codigo_marca int not null,
	primary key (codigo_modelo),
	foreign key (codigo_marca) REFERENCES locadora_veiculos_marca (codigo_marca)
);

create table locadora_veiculos_veiculo
(
	placa_veiculo varchar (7) not null,
	chassi_veiculo varchar (45) not null,
	numero_motor_veiculo varchar (45) not null,
	status_veiculo varchar (45) not null,
	km_atual_veiculo varchar (45) not null,
	codigo_modelo int not null,
	codigo_tipo_veiculo int not null,
	cnpj_locadora varchar (20) not null,
	primary key (placa_veiculo),
	foreign key (codigo_modelo) REFERENCES locadora_veiculos_modelo (codigo_modelo),
    foreign key (codigo_tipo_veiculo) REFERENCES locadora_veiculos_tipo_veiculo (codigo_tipo_veiculo),
    foreign key (cnpj_locadora) REFERENCES locadora_veiculos_locadora (cnpj_locadora)
);

create table locadora_veiculos_cliente
(
	codigo_cliente int not null AUTO_INCREMENT,
	nome_cliente varchar (255) not null,
	endereco_cliente varchar (255) not null,
	primary key (codigo_cliente)
);

create table locadora_veiculos_pessoa_fisica
(
	cpf_pessoa_fisica varchar (15) not null,
	sexo_pessoa_fisica varchar (45) not null,
	data_nascimento_pessoa_fisica Date not null,
	codigo_cliente int not null,
	foreign key (codigo_cliente) REFERENCES locadora_veiculos_cliente (codigo_cliente)
);

create table locadora_veiculos_pessoa_juridica
(
	cnpj_pessoa_juridica varchar (15) not null,
	inscricao_estadual_pessoa_juridica varchar (20) not null,
	codigo_cliente int not null,
	foreign key (codigo_cliente) REFERENCES locadora_veiculos_cliente (codigo_cliente)
);

create table locadora_veiculos_reserva
(
	codigo_reserva int not null AUTO_INCREMENT,
	data_reserva Date not null,
	data_retirada_veiculo_reserva Date not null,
	status_reserva varchar (45),
	codigo_tipo_veiculo int not null,
	codigo_cliente int not null,
	primary key (codigo_reserva),
	foreign key (codigo_tipo_veiculo) REFERENCES locadora_veiculos_tipo_veiculo (codigo_tipo_veiculo),
	foreign key (codigo_cliente) REFERENCES locadora_veiculos_cliente (codigo_cliente)
);

create table locadora_veiculos_aluguel
(
	codigo_aluguel int not null AUTO_INCREMENT,
	data_aluguel Date not null,
	data_prevista_entrega_aluguel Date not null,
	data_entrega_aluguel Date null,
	nome_motorista_aluguel varchar (255) not null,
	cnh_motorista_aluguel varchar (2),
	data_validade_cnh_aluguel Date not null,
	km_rodada_aluguel int not null,
	valor_aluguel float null,
	placa_veiculo varchar (7) not null,
	cnpj_locadora_origem varchar (20) not null,
	cnpj_locadora_destino varchar (20) not null,
	codigo_cliente int not null,
	primary key (codigo_aluguel),
	foreign key (placa_veiculo) REFERENCES locadora_veiculos_veiculo (placa_veiculo),
	foreign key (cnpj_locadora_origem) REFERENCES locadora_veiculos_locadora (cnpj_locadora),
	foreign key (cnpj_locadora_destino) REFERENCES locadora_veiculos_locadora (cnpj_locadora),
	foreign key (codigo_cliente) REFERENCES locadora_veiculos_cliente (codigo_cliente)
);

DROP TABLE locadora_veiculos_telefone, locadora_veiculos_veiculo, locadora_veiculos_tipo_veiculo, locadora_veiculos_reserva, locadora_veiculos_pessoa_juridica, 
locadora_veiculos_pessoa_fisica, locadora_veiculos_modelo, locadora_veiculos_marca, locadora_veiculos_locadora, locadora_veiculos_cliente, locadora_veiculos_aluguel