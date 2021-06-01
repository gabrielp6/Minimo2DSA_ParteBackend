DROP DATABASE IF EXISTS bbdd;
CREATE DATABASE bbdd;

USE bbdd;


CREATE TABLE usuario(
	username VARCHAR(30) NOT NULL,
	contraseña VARCHAR(30),
	correo VARCHAR(50),
	idUsuario INT,
	monedas INT,
	PRIMARY KEY(username)
)ENGINE = InnoDB;

CREATE TABLE objeto(
	nombre VARCHAR(30),
	idObjeto INT,
	coste INT	
)ENGINE = InnoDB;

CREATE TABLE mapa(
	nombre VARCHAR(30),
	enemigos INT
)ENGINE = InnoDB;


CREATE TABLE partida(
   	usuario VARCHAR(30),
	tiempo INT,
	monedasrecogidas INT,
	enemigosmatados INT,
	FOREIGN KEY (usuario) REFERENCES usuario(username)
)ENGINE = InnoDB

______________________________


INSERT INTO usuario (username, contraseña, correo, idUsuario, monedas) VALUES ('gabriel6','holahola','gabriel11@gmail.com', 1, 150);
INSERT INTO objeto (nombre, idObjeto, coste) VALUES ('pocion', 1, 20);
INSERT INTO mapa (nombre, enemigos) VALUES ('bosque',4");
INSERT INTO partida (548, 23, 4);