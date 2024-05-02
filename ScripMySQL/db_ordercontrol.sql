create database db_ordercontrol;
use db_ordercontrol;
CREATE TABLE IF NOT EXISTS tb_cadastro(
	id int primary key auto_increment,
    nome varchar(200),
    senha varchar(200),
    email varchar(200),
    idade int,
    cpf int,
    admin int,
    sexo varchar(1)
);
