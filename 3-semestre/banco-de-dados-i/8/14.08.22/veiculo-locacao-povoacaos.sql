INSERT INTO locadora_veiculos_locadora (cnpj_locadora, razao_social_locadora, endereco_locadora) VALUES ("1", "16323", "sei la");
INSERT INTO locadora_veiculos_locadora (cnpj_locadora, razao_social_locadora, endereco_locadora) VALUES ("2", "23634", "Disney");
INSERT INTO locadora_veiculos_locadora (cnpj_locadora, razao_social_locadora, endereco_locadora) VALUES ("3", "34365", "Orlando");
INSERT INTO locadora_veiculos_locadora (cnpj_locadora, razao_social_locadora, endereco_locadora) VALUES ("4", "4554366", "Acre");
INSERT INTO locadora_veiculos_locadora (cnpj_locadora, razao_social_locadora, endereco_locadora) VALUES ("5", "9434536", "Beverly hills");

INSERT INTO locadora_veiculos_telefone (telefone_telefone, cnpj_locadora) VALUES ("1", "1");
INSERT INTO locadora_veiculos_telefone (telefone_telefone, cnpj_locadora) VALUES ("2", "2");
INSERT INTO locadora_veiculos_telefone (telefone_telefone, cnpj_locadora) VALUES ("3", "3");
INSERT INTO locadora_veiculos_telefone (telefone_telefone, cnpj_locadora) VALUES ("4", "4");
INSERT INTO locadora_veiculos_telefone (telefone_telefone, cnpj_locadora) VALUES ("5", "5");

INSERT INTO locadora_veiculos_tipo_veiculo (descricao_tipo_veiculo, porte_tipo_veiculo, tamanho_tipo_veiculo, numero_passageiros_tipo_veiculo, numero_portas_tipo_veiculo, 
arcondicionado_tipo_veiculo, multimidia_tipo_veiculo, direcao_hidraulica_tipo_veiculo, cambio_automatico_tipo_veiculo, capacidade_carga_tipo_veiculo) 
VALUES ("Urbano", "Medío", null, null, null, null, null, null, null, null);
INSERT INTO locadora_veiculos_tipo_veiculo (descricao_tipo_veiculo, porte_tipo_veiculo, tamanho_tipo_veiculo, numero_passageiros_tipo_veiculo, numero_portas_tipo_veiculo, 
arcondicionado_tipo_veiculo, multimidia_tipo_veiculo, direcao_hidraulica_tipo_veiculo, cambio_automatico_tipo_veiculo, capacidade_carga_tipo_veiculo) 
VALUES ("Flex", "Médio", null, null, null, null, null, null, null, null);
INSERT INTO locadora_veiculos_tipo_veiculo (descricao_tipo_veiculo, porte_tipo_veiculo, tamanho_tipo_veiculo, numero_passageiros_tipo_veiculo, numero_portas_tipo_veiculo, 
arcondicionado_tipo_veiculo, multimidia_tipo_veiculo, direcao_hidraulica_tipo_veiculo, cambio_automatico_tipo_veiculo, capacidade_carga_tipo_veiculo) 
VALUES ("Corrida", "Pequeno", null, null, null, null, null, null, null, null);
INSERT INTO locadora_veiculos_tipo_veiculo (descricao_tipo_veiculo, porte_tipo_veiculo, tamanho_tipo_veiculo, numero_passageiros_tipo_veiculo, numero_portas_tipo_veiculo, 
arcondicionado_tipo_veiculo, multimidia_tipo_veiculo, direcao_hidraulica_tipo_veiculo, cambio_automatico_tipo_veiculo, capacidade_carga_tipo_veiculo) 
VALUES ("Futurista", "Médio", null, null, null, null, null, null, null, null);
INSERT INTO locadora_veiculos_tipo_veiculo (descricao_tipo_veiculo, porte_tipo_veiculo, tamanho_tipo_veiculo, numero_passageiros_tipo_veiculo, numero_portas_tipo_veiculo, 
arcondicionado_tipo_veiculo, multimidia_tipo_veiculo, direcao_hidraulica_tipo_veiculo, cambio_automatico_tipo_veiculo, capacidade_carga_tipo_veiculo) 
VALUES ("Viagem", "Grande", null, null, null, null, null, null, null, null);

INSERT INTO locadora_veiculos_marca (descricao_marca) VALUES ("Mazda");
INSERT INTO locadora_veiculos_marca (descricao_marca) VALUES ("Honda");
INSERT INTO locadora_veiculos_marca (descricao_marca) VALUES ("BMW");
INSERT INTO locadora_veiculos_marca (descricao_marca) VALUES ("Tesla");
INSERT INTO locadora_veiculos_marca (descricao_marca) VALUES ("Ferrari");

INSERT INTO locadora_veiculos_modelo (descricao_modelo, codigo_marca) VALUES ("3 Portas", 1);
INSERT INTO locadora_veiculos_modelo (descricao_modelo, codigo_marca) VALUES ("Trava Eletrica", 2);
INSERT INTO locadora_veiculos_modelo (descricao_modelo, codigo_marca) VALUES ("Flex", 3);
INSERT INTO locadora_veiculos_modelo (descricao_modelo, codigo_marca) VALUES ("Sensor de Ré", 4);
INSERT INTO locadora_veiculos_modelo (descricao_modelo, codigo_marca) VALUES ("Automatico", 5);

INSERT INTO locadora_veiculos_veiculo (placa_veiculo, chassi_veiculo, numero_motor_veiculo, status_veiculo, km_atual_veiculo, codigo_modelo, codigo_tipo_veiculo, cnpj_locadora) 
VALUES ("1", "325345", "32525", "345345", "53636", 1, 1, 1);
INSERT INTO locadora_veiculos_veiculo (placa_veiculo, chassi_veiculo, numero_motor_veiculo, status_veiculo, km_atual_veiculo, codigo_modelo, codigo_tipo_veiculo, cnpj_locadora) 
VALUES ("2", "325345", "32525", "345345", "53636", 2, 2, 2);
INSERT INTO locadora_veiculos_veiculo (placa_veiculo, chassi_veiculo, numero_motor_veiculo, status_veiculo, km_atual_veiculo, codigo_modelo, codigo_tipo_veiculo, cnpj_locadora) 
VALUES ("3", "325345", "32525", "345345", "53636", 3, 3, 3);
INSERT INTO locadora_veiculos_veiculo (placa_veiculo, chassi_veiculo, numero_motor_veiculo, status_veiculo, km_atual_veiculo, codigo_modelo, codigo_tipo_veiculo, cnpj_locadora) 
VALUES ("4", "325345", "32525", "345345", "53636", 4, 4, 4);
INSERT INTO locadora_veiculos_veiculo (placa_veiculo, chassi_veiculo, numero_motor_veiculo, status_veiculo, km_atual_veiculo, codigo_modelo, codigo_tipo_veiculo, cnpj_locadora) 
VALUES ("5", "325345", "32525", "345345", "53636", 5, 5, 5);

INSERT INTO locadora_veiculos_cliente (nome_cliente, endereco_cliente) VALUES ("Gustavo", "Rua do Zezinhho 925");
INSERT INTO locadora_veiculos_cliente (nome_cliente, endereco_cliente) VALUES ("Pedrinho", "Rua do Dirceu 3022");
INSERT INTO locadora_veiculos_cliente (nome_cliente, endereco_cliente) VALUES ("Andre", "Rua do Campetes 0009");
INSERT INTO locadora_veiculos_cliente (nome_cliente, endereco_cliente) VALUES ("Robson", "Rua do São Sebastiao 4423");
INSERT INTO locadora_veiculos_cliente (nome_cliente, endereco_cliente) VALUES ("Moacir", "Rua do Tigre 3635");

INSERT INTO locadora_veiculos_pessoa_fisica (cpf_pessoa_fisica, sexo_pessoa_fisica, data_nascimento_pessoa_fisica, codigo_cliente) VALUES ("12332199989", "Masculino", '1979-09-06', 1);
INSERT INTO locadora_veiculos_pessoa_fisica (cpf_pessoa_fisica, sexo_pessoa_fisica, data_nascimento_pessoa_fisica, codigo_cliente) VALUES ("12332199989", "Feminino", '2001-01-22', 2);
INSERT INTO locadora_veiculos_pessoa_fisica (cpf_pessoa_fisica, sexo_pessoa_fisica, data_nascimento_pessoa_fisica, codigo_cliente) VALUES ("12332199989", "Masculino", '1820-04-12', 3);
INSERT INTO locadora_veiculos_pessoa_fisica (cpf_pessoa_fisica, sexo_pessoa_fisica, data_nascimento_pessoa_fisica, codigo_cliente) VALUES ("12332199989", "Feminino", '1069-08-24', 4);
INSERT INTO locadora_veiculos_pessoa_fisica (cpf_pessoa_fisica, sexo_pessoa_fisica, data_nascimento_pessoa_fisica, codigo_cliente) VALUES ("12332199989", "Feminino", '1069-08-24', 5);

INSERT INTO locadora_veiculos_pessoa_juridica (cnpj_pessoa_juridica, inscricao_estadual_pessoa_juridica, codigo_cliente) VALUES ("12345678912345", "3881372598269", 1);
INSERT INTO locadora_veiculos_pessoa_juridica (cnpj_pessoa_juridica, inscricao_estadual_pessoa_juridica, codigo_cliente) VALUES ("98765432198765", "3881083598269", 2);
INSERT INTO locadora_veiculos_pessoa_juridica (cnpj_pessoa_juridica, inscricao_estadual_pessoa_juridica, codigo_cliente) VALUES ("98765432198700", "3882131598269", 3);
INSERT INTO locadora_veiculos_pessoa_juridica (cnpj_pessoa_juridica, inscricao_estadual_pessoa_juridica, codigo_cliente) VALUES ("23232323232322", "7532085982269", 4);
INSERT INTO locadora_veiculos_pessoa_juridica (cnpj_pessoa_juridica, inscricao_estadual_pessoa_juridica, codigo_cliente) VALUES ("69696969696922", "3881089999999", 5);

INSERT INTO locadora_veiculos_reserva (data_reserva, data_retirada_veiculo_reserva, status_reserva, codigo_tipo_veiculo, codigo_cliente) VALUES ('2010-12-18', '2010-12-18', "1", 1, 1);
INSERT INTO locadora_veiculos_reserva (data_reserva, data_retirada_veiculo_reserva, status_reserva, codigo_tipo_veiculo, codigo_cliente) VALUES ('2004-04-25', '2004-04-25', "2", 2, 2);
INSERT INTO locadora_veiculos_reserva (data_reserva, data_retirada_veiculo_reserva, status_reserva, codigo_tipo_veiculo, codigo_cliente) VALUES ('1965-06-16', '1965-06-16', "3", 3, 3);
INSERT INTO locadora_veiculos_reserva (data_reserva, data_retirada_veiculo_reserva, status_reserva, codigo_tipo_veiculo, codigo_cliente) VALUES ('1994-08-03', '1994-08-03', "4", 4, 4);
INSERT INTO locadora_veiculos_reserva (data_reserva, data_retirada_veiculo_reserva, status_reserva, codigo_tipo_veiculo, codigo_cliente) VALUES ('2016-09-16', '2016-09-16', "5", 5, 5);

INSERT INTO locadora_veiculos_aluguel (data_aluguel, data_prevista_entrega_aluguel, data_entrega_aluguel, nome_motorista_aluguel, cnh_motorista_aluguel, data_validade_cnh_aluguel, km_rodada_aluguel, 
valor_aluguel, placa_veiculo, cnpj_locadora_origem, cnpj_locadora_destino, codigo_cliente) VALUES ('1678-12-30', '1678-12-30', '1678-12-30', "Bartolomel", "1", '1678-12-30', 1, 1, "1", "1", "1", 1);
INSERT INTO locadora_veiculos_aluguel (data_aluguel, data_prevista_entrega_aluguel, data_entrega_aluguel, nome_motorista_aluguel, cnh_motorista_aluguel, data_validade_cnh_aluguel, km_rodada_aluguel, 
valor_aluguel, placa_veiculo, cnpj_locadora_origem, cnpj_locadora_destino, codigo_cliente) VALUES ('1944-06-14', '1944-06-14', '1944-06-14', "Cleiton", "2", '1944-06-14', 2, 2, "2", "2", "2", 2);
INSERT INTO locadora_veiculos_aluguel (data_aluguel, data_prevista_entrega_aluguel, data_entrega_aluguel, nome_motorista_aluguel, cnh_motorista_aluguel, data_validade_cnh_aluguel, km_rodada_aluguel, 
valor_aluguel, placa_veiculo, cnpj_locadora_origem, cnpj_locadora_destino, codigo_cliente) VALUES ('2015-05-12', '2015-05-12', '2015-05-12', "Jonas", "3", '2015-05-12', 3, 3, "3", "3", "3", 3);
INSERT INTO locadora_veiculos_aluguel (data_aluguel, data_prevista_entrega_aluguel, data_entrega_aluguel, nome_motorista_aluguel, cnh_motorista_aluguel, data_validade_cnh_aluguel, km_rodada_aluguel, 
valor_aluguel, placa_veiculo, cnpj_locadora_origem, cnpj_locadora_destino, codigo_cliente) VALUES ('2019-03-05', '2019-03-05', '2019-03-05', "Jubilel", "4", '2019-03-05', 4, 4, "4", "4", "4", 4);
INSERT INTO locadora_veiculos_aluguel (data_aluguel, data_prevista_entrega_aluguel, data_entrega_aluguel, nome_motorista_aluguel, cnh_motorista_aluguel, data_validade_cnh_aluguel, km_rodada_aluguel, 
valor_aluguel, placa_veiculo, cnpj_locadora_origem, cnpj_locadora_destino, codigo_cliente) VALUES ('2018-01-03', '2018-01-03', '2018-01-03', "Choriscreuda", "5", '2018-01-03', 5, 5, "5", "5", "5", 5);