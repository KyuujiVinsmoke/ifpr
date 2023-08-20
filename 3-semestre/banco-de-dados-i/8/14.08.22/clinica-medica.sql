create table clinica_medica_paciente
(
    codigo_paciente INT NOT NULL AUTO_INCREMENT,
    nome_paciente VARCHAR(255) NOT NULL,
    data_nascimento_paciente DATE NOT NULL,
    sexo_paciente BIT NOT NULL,
    prontuario_paciente VARCHAR(255) NOT NULL,
    endereco_paciente VARCHAR(255) NOT NULL,
    cpf_paciente VARCHAR(45) NULL,
    rg_paciente VARCHAR(45) NULL,
    obs_paciente VARCHAR(45) NULL,
    PRIMARY KEY (codigo_paciente)
);

create table clinica_medica_telefone_paciente
(
    telefone_paciente VARCHAR(15) NOT NULL,
    codigo_paciente INT NOT NULL,
    PRIMARY KEY (telefone_paciente),
    FOREIGN KEY (codigo_paciente) REFERENCES clinica_medica_paciente (codigo_paciente)
);

create table clinica_medica_exames
(
    codigo_exames INT NOT NULL AUTO_INCREMENT,
    nome_exames VARCHAR(45) NOT NULL,
    valor_exames FLOAT NOT NULL,
    status_exames VARCHAR(45) NOT NULL,
    instrucao_exames VARCHAR(255) NOT NULL,
    PRIMARY KEY (codigo_exames)
);

create table clinica_medica_agendamento
(
    codigo_agendamento INT NOT NULL,
    data_agendamento DATE NOT NULL,
    data_exame_agendamento DATE NOT NULL,
    hora_exame_agendamento TIME NOT NULL,
    hora_exame_realizado_agendamento TIME NULL,
    codigo_paciente INT NOT NULL,
    codigo_exames INT NOT NULL,
    PRIMARY KEY (codigo_agendamento),
    FOREIGN KEY (codigo_paciente) REFERENCES clinica_medica_paciente (codigo_paciente),
    FOREIGN KEY (codigo_exames) REFERENCES clinica_medica_exames (codigo_exames)
);

create table clinica_medica_medico
(
    cm_medico INT NOT NULL,
    nome_medico VARCHAR(255) NOT NULL,
    especialidade_medico VARCHAR(45) NOT NULL,
    dias_atendimento_medico VARCHAR(255) NOT NULL,
    horarios_atendimento_medico VARCHAR(255) NOT NULL,
    PRIMARY KEY (cm_medico)
);

create table clinica_medica_consulta
(
    codigo_consulta INT NOT NULL AUTO_INCREMENT,
    data_agendamento_consulta DATE NOT NULL,
    data_agendada_consulta DATE NOT NULL,
    hora_agendamento_consulta TIME NOT NULL,
    hora_realizada_consulta TIME NULL,
    valor_consulta FLOAT NOT NULL,
    status_consulta VARCHAR(45) NOT NULL,
    cm_medico INT NOT NULL,
    codigo_paciente INT NOT NULL,
    PRIMARY KEY (codigo_consulta),
    FOREIGN KEY (codigo_paciente) REFERENCES clinica_medica_paciente (codigo_paciente),
    FOREIGN KEY (cm_medico) REFERENCES clinica_medica_medico (cm_medico)
);

create table clinica_medica_consulta_exame
(
    codigo_exames INT NOT NULL,
    codigo_consulta INT NOT NULL,
    FOREIGN KEY (codigo_exames) REFERENCES clinica_medica_exames (codigo_exames),
    FOREIGN KEY (codigo_consulta) REFERENCES clinica_medica_consulta (codigo_consulta)
);

create table clinica_medica_receita
(
    codigo_receita INT NOT NULL AUTO_INCREMENT,
    medicamento_receita VARCHAR(45) NOT NULL,
    posologia_receita VARCHAR(45) NOT NULL,
    observacao_receita VARCHAR(45) NOT NULL,
    codigo_consulta INT NOT NULL,
    PRIMARY KEY (codigo_receita),
    FOREIGN KEY (codigo_consulta) REFERENCES clinica_medica_consulta (codigo_consulta)
);