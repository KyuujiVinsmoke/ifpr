
CREATE TABLE IF NOT EXISTS despesas(
    id INTEGER PRIMARY KEY, 
    titulo TEXT NOT NULL, 
    valor REAL NOT NULL,
    data INTEGER NOT NULL,
    tipo TEXT NOT NULL
);
