create table curso_idiomas_pessoa(
	codigo int not null AUTO_INCREMENT,
	nome varchar(255) not null,
	endereco varchar(255) not null,
	primary key(codigo)
);

create table curso_idiomas_telefone(
	telefone varchar(45) not null,
	codigo_pessoa int not null,
	primary key(telefone, codigo_pessoa),
	foreign key(codigo_pessoa) REFERENCES curso_idiomas_pessoa(codigo)
);

create table curso_idiomas_professor(
	codigo_pessoa int not null,
	formacao varchar(45) not null,
	primary key(codigo_pessoa),
	foreign key(codigo_pessoa) REFERENCES curso_idiomas_pessoa(codigo)
);

create table curso_idiomas_aluno(
	codigo_pessoa int not null,
	data_nascimento Date not null,
	sexo bit not null,
	rg varchar(45) null,
	cpf varchar(45) null,
	primary key(codigo_pessoa),
	foreign key(codigo_pessoa) REFERENCES curso_idiomas_pessoa(codigo)
);

create table curso_idiomas_idiomas(
	codigo int not null AUTO_INCREMENT,
	descricao varchar(45) not null,
	primary key(codigo)
);

create table curso_idiomas_pre_requisito(
	pre_requisito1 int not null,
	pre_requisito2 int not null,
	primary key(pre_requisito1, pre_requisito2),
	foreign key(pre_requisito1) REFERENCES curso_idiomas_idiomas(codigo),
	foreign key(pre_requisito2) REFERENCES curso_idiomas_idiomas(codigo)
);

create table curso_idiomas_ministra(
	codigo_idioma int not null,
	codigo_professor int not null,
	primary key(codigo_idioma, codigo_professor),
	foreign key(codigo_idioma) REFERENCES curso_idiomas_idiomas(codigo),
	foreign key(codigo_professor) REFERENCES curso_idiomas_professor(codigo_pessoa)
);


create table curso_idiomas_turma(
	codigo int not null AUTO_INCREMENT,
	codigo_idioma int not null,
	codigo_professor int not null,
	data_inicio int not null,
	data_termino int not null,
	dias_da_semana varchar(45) not null,
	horario_inicio_aula TIME not null,
	horario_termino_aula TIME not null,
	nivel int not null,
	primary key(codigo),
	foreign key(codigo_idioma) REFERENCES curso_idiomas_idiomas(codigo),
	foreign key(codigo_professor) REFERENCES curso_idiomas_professor(codigo_pessoa)
);

create table curso_idiomas_frequencia(
	codigo_turma int not null,
	codigo_aluno int not null,
	data Date not null,
	registro Bit not null,
	primary key(codigo_turma, codigo_aluno),
	foreign key(codigo_turma) REFERENCES curso_idiomas_turma(codigo),
	foreign key(codigo_aluno) REFERENCES curso_idiomas_aluno(codigo_pessoa)
);

create table curso_idiomas_material_didatico(
	codigo int not null AUTO_INCREMENT,
	descricao varchar(45) not null,
	primary key(codigo)
);

create table  curso_idiomas_matricula(
	codigo_matricula int not null AUTO_INCREMENT,
	codigo_material_didatico int not null,
	codigo_turma int not null,
	codigo_pessoa int not null,
	valor_mensalidade float not null,
	data_matricula Date null,
	primary key(codigo_matricula),
	foreign key(codigo_material_didatico) REFERENCES curso_idiomas_material_didatico(codigo),
	foreign key(codigo_turma) REFERENCES curso_idiomas_turma(codigo),
	foreign key(codigo_pessoa) REFERENCES curso_idiomas_aluno(codigo_pessoa)
);