create database db_ordercontrol;
use db_ordercontrol;
CREATE TABLE IF NOT EXISTS tb_cadastro(
	id int primary key auto_increment,
    nome varchar(200) NOT NULL,
    senha varchar(200) NOT NULL,
    email varchar(200) NOT NULL,
    idade int NOT NULL,
    cpf int NOT NULL,
    admin int NOT NULL,
    sexo varchar(1) NOT NULL
);

CREATE TABLE if NOT EXISTS tb_eventos(
    id int PRIMARY KEY auto_increment,
    tipoEvento int NOT NULL,
    nomeCliente VARCHAR(200) NOT NULL,
    local VARCHAR(200) NOT NULL,
    data VARCHAR(200) NOT NULL,
    hora VARCHAR(200) NOT NULL,
    descricao TEXT NOT NULL
);
