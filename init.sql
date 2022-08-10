CREATE TABLE IF NOT EXISTS tablero (
	id SERIAL PRIMARY KEY, 
	nombre VARCHAR(50) NOT NULL);

INSERT INTO tablero(nombre) VALUES('Tablero-1');
INSERT INTO tablero(nombre) VALUES('Tablero-2');