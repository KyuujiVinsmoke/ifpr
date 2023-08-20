INSERT INTO empresa_estado (sigla_estado, nome_estado) VALUES ("PR", "PARANA");
INSERT INTO empresa_estado (sigla_estado, nome_estado) VALUES ("SC", "SANTA CATARINA");
INSERT INTO empresa_estado (sigla_estado, nome_estado) VALUES ("SP", "SAO PAULO");

INSERT INTO empresa_cidade (nome_cidade, sigla_estado) VALUES ("CURITIBA", "PR");
INSERT INTO empresa_cidade (nome_cidade, sigla_estado) VALUES ("PONTAL DO PARANA", "PR");
INSERT INTO empresa_cidade (nome_cidade, sigla_estado) VALUES ("MORRETES", "PR");
INSERT INTO empresa_cidade (nome_cidade, sigla_estado) VALUES ("JOINVILLE", "SC");
INSERT INTO empresa_cidade (nome_cidade, sigla_estado) VALUES ("SAO FRANCISCO", "SC");
INSERT INTO empresa_cidade (nome_cidade, sigla_estado) VALUES ("FLORIANOPOLIS", "SC");
INSERT INTO empresa_cidade (nome_cidade, sigla_estado) VALUES ("SAO PAULO", "SP");
INSERT INTO empresa_cidade (nome_cidade, sigla_estado) VALUES ("LINS", "SP");
INSERT INTO empresa_cidade (nome_cidade, sigla_estado) VALUES ("ARARAQUARA", "SP");

INSERT INTO empresa_departamento (nome_departamento, codigo_cidade, cpf_gerente_departamento) VALUES ("ADMINISTRATIVO", 7, null);
INSERT INTO empresa_departamento (nome_departamento, codigo_cidade, cpf_gerente_departamento) VALUES ("FINANCEIRO", 7, 2);
INSERT INTO empresa_departamento (nome_departamento, codigo_cidade, cpf_gerente_departamento) VALUES ("RECURSOS HUMANOS", 1, 3);
INSERT INTO empresa_departamento (nome_departamento, codigo_cidade, cpf_gerente_departamento) VALUES ("COMPRAS", 1, 4);
INSERT INTO empresa_departamento (nome_departamento, codigo_cidade, cpf_gerente_departamento) VALUES ("VENDAS", 1, 5);

INSERT INTO empresa_projeto (nome_projeto, descricao_projeto, codigo_cidade, codigo_departamento) VALUES ("ACAO1", "TESTE1", 7, 1);
INSERT INTO empresa_projeto (nome_projeto, descricao_projeto, codigo_cidade, codigo_departamento) VALUES ("ACAO2", "TESTE2", 7, 2);
INSERT INTO empresa_projeto (nome_projeto, descricao_projeto, codigo_cidade, codigo_departamento) VALUES ("ACAO3", "TESTE3", 5, 2);
INSERT INTO empresa_projeto (nome_projeto, descricao_projeto, codigo_cidade, codigo_departamento) VALUES ("ACAO4", "TESTE4", 7, 3);
INSERT INTO empresa_projeto (nome_projeto, descricao_projeto, codigo_cidade, codigo_departamento) VALUES ("ACAO5", "TESTE5", 5, 2);
INSERT INTO empresa_projeto (nome_projeto, descricao_projeto, codigo_cidade, codigo_departamento) VALUES ("ACAO6", "TESTE6", 7, 1);

INSERT INTO empresa_funcionario (cpf_funcionario, datanasc_funcionario, nome_funcionario, endereco_funcionario, salario_funcionario, sexo_funcionario, cpf_supervisor_funcionario, codigo_departamento)
VALUES ("1", "1970-01-31", "WAGNER", "IFPR", 12000, "M", null, 1);
INSERT INTO empresa_funcionario (cpf_funcionario, datanasc_funcionario, nome_funcionario, endereco_funcionario, salario_funcionario, sexo_funcionario, cpf_supervisor_funcionario, codigo_departamento)
VALUES ("2", "1990-01-31", "RODRIGO", "IFPR", 8000, "M", 1, 1);
INSERT INTO empresa_funcionario (cpf_funcionario, datanasc_funcionario, nome_funcionario, endereco_funcionario, salario_funcionario, sexo_funcionario, cpf_supervisor_funcionario, codigo_departamento)
VALUES ("3", "1990-01-10", "ANA", "IFPR", 10000, "F", 1, 2);
INSERT INTO empresa_funcionario (cpf_funcionario, datanasc_funcionario, nome_funcionario, endereco_funcionario, salario_funcionario, sexo_funcionario, cpf_supervisor_funcionario, codigo_departamento)
VALUES ("4", "1960-01-20", "LIGIA", "IFPR", 15000, "F", 1, 2);
INSERT INTO empresa_funcionario (cpf_funcionario, datanasc_funcionario, nome_funcionario, endereco_funcionario, salario_funcionario, sexo_funcionario, cpf_supervisor_funcionario, codigo_departamento)
VALUES ("5", "1960-01-20", "LEONARDO", "IFPR", 15000, "M", 2, 2);
INSERT INTO empresa_funcionario (cpf_funcionario, datanasc_funcionario, nome_funcionario, endereco_funcionario, salario_funcionario, sexo_funcionario, cpf_supervisor_funcionario, codigo_departamento)
VALUES ("6", "1985-01-20", "MARIA", "IFPR", 5000, "F", null, 4);

INSERT INTO empresa_funcionario_projeto (cpf_funcionario, codigo_projeto) VALUES (1, 1);
INSERT INTO empresa_funcionario_projeto (cpf_funcionario, codigo_projeto) VALUES (2, 1);
INSERT INTO empresa_funcionario_projeto (cpf_funcionario, codigo_projeto) VALUES (3, 1);
INSERT INTO empresa_funcionario_projeto (cpf_funcionario, codigo_projeto) VALUES (4, 1);
INSERT INTO empresa_funcionario_projeto (cpf_funcionario, codigo_projeto) VALUES (1, 2);
INSERT INTO empresa_funcionario_projeto (cpf_funcionario, codigo_projeto) VALUES (2, 2);
INSERT INTO empresa_funcionario_projeto (cpf_funcionario, codigo_projeto) VALUES (3, 2);
INSERT INTO empresa_funcionario_projeto (cpf_funcionario, codigo_projeto) VALUES (4, 2);
INSERT INTO empresa_funcionario_projeto (cpf_funcionario, codigo_projeto) VALUES (1, 3);
INSERT INTO empresa_funcionario_projeto (cpf_funcionario, codigo_projeto) VALUES (1, 4);