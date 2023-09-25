CREATE TABLE IF NOT EXISTS generos (
    id INTEGER PRIMARY KEY,
    nome varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS artistas (
    id INTEGER PRIMARY KEY,
    nome varchar(255) NOT NULL,
    contato varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS musicas (
    id INTEGER PRIMARY KEY,
    nome varchar(255) NOT NULL,
    duracao int NOT NULL,
    anoLancamento int NOT NULL,
    artistaId int NOT NULL,
    generoId int NOT NULL,
    FOREIGN KEY (artistaId) REFERENCES artistas(id),
    FOREIGN KEY (generoId) REFERENCES generos(id)
);

CREATE TABLE IF NOT EXISTS playlists (
    id INTEGER PRIMARY KEY,
    nome varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS playlistsMusicas (
    id INTEGER PRIMARY KEY,
    musicasId int NOT NULL,
    playlistsId int NOT NULL,
    FOREIGN KEY (musicasId) REFERENCES musicas(id),
    FOREIGN KEY (playlistsId) REFERENCES playlists(id)
);

INSERT INTO generos (nome) VALUES ('1');
INSERT INTO artistas (nome, contato) VALUES ('1', '1');
INSERT INTO musicas (nome, duracao, anoLancamento, artistaId, generoId) VALUES ('1', 1, 1, 1, 1);
INSERT INTO playlists (nome) VALUES ('1');
INSERT INTO playlistsMusicas (playlistsId, musicasId) VALUES (1, 1);