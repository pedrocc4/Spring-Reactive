DROP TABLE IF EXISTS tablero;
CREATE TABLE tablero (
	id SERIAL PRIMARY KEY,
	nombre VARCHAR(50) NOT NULL,
    nfilas INTEGER,
    ncolumnas INTEGER,
    matrix INTEGER[][]);
