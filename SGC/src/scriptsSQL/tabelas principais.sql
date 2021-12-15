create database bd_artquadros
 default character set utf8 
 default collate utf8_general_ci;
 
 use bd_artquadros;
 
 create table cliente_nome (
 id int auto_increment,
 nome varchar(50) not null,
 primary key(id)
 );
  
 create table cliente_insc_estadual(
 id int,
 insc_estadual varchar(16),
 constraint fk_cliente_insc_estadual foreign key(id) references cliente_nome(id) on delete cascade on update cascade,
 primary key(insc_estadual)
 );

drop table cliente_insc_estadual;
 
 create table cliente_cpf(
 id int,
 cpf varchar(14),
 constraint fk_cliente_cpf foreign key(id) references cliente_nome(id) on delete cascade on update cascade,
 primary key(cpf)
 );
 

 
 create table cliente_email(
 id int,
 email varchar(20),
 constraint fk_cliente_email foreign key(id) references cliente_nome(id) on delete cascade on update cascade,
 primary key(email)
 );
  
 create table cliente_cnpj(
 id int,
 cnpj varchar(18),
 constraint fk_cliente_cnpj foreign key(id) references cliente_nome(id) on delete cascade on update cascade,
 primary key(cnpj)
 );
 

 create table nota(
 id int auto_increment,
 data_entrega date not null,
 data_da_nota date not null,
 desconto tinyint,
 valor_total decimal(5,2) not null,
 valor_entrada decimal(5,2),
 forma_pagamento varchar(20) default ('Dinheiro a Vista'),
 descricao text,
 primary key(id)
 );
 
 create table nota_status(
id int,
status_pagamento varchar(10),
data_encerramento date,
constraint fk_nota_status foreign key(id) references nota(id) on delete cascade on update cascade
);
 
create table pedido(
id int auto_increment,
altura decimal(3,2) not null,
largura decimal(3,2) not null,
valor_unitario float(5,2) not null,
tipo varchar(15) not null,
quantidade smallint not null,
descricao text,
primary key(id)
);

create table vidro(
id int auto_increment,
tipo varchar(30) not null,
altura_chapa decimal(5,2) not null,
comprimento_chapa decimal(5,2) not null,
espessura_chapa tinyint not null,
quant_chapas tinyint not null,
preco_custo float(5,2) not null,
primary key(id)
);
use bd_artquadros;
drop table vidro;

create table eucatex(
id int auto_increment,
tipo varchar(20) not null,
altura_chapa decimal(3,2) not null,
comprimento_chapa decimal(3,2) not null,
quant_chapas tinyint not null,
preco_custo float(5,2) not null,
primary key(id)
);

drop table eucatex;

create table moldura(
id varchar(20),
cor varchar(25),
descricao text,
material varchar(20),
quant_metros decimal(5,2) not null,
comprimento_vara decimal(3,2) not null,
largura_vara decimal(4,2) not null,
primary key(id)
);

drop table moldura;

create table moldura_preco(
id varchar(20),
preco_custo float(5,2) not null,
preco_venda float(5,2) not null,
constraint fk_moldura_preco foreign key(id) references moldura(id) on delete cascade on update cascade
);


create table endereco(
id int auto_increment,
uf char(2) default 'MG' not null,
cidade varchar(30) default 'Ubá' not null,
bairro varchar(30) not null,
rua varchar(30) not null,
complemento varchar(20),
numero varchar(10) not null,
referencia text,
primary key(id)
);

drop table endereco;

create table fornecedor(
cnpj varchar(18),
nome varchar(50) not null,
descricao text not null,
primary key(cnpj)
);

create table fornecedor_email(
cnpj varchar(18),
email varchar(50) not null,
constraint fk_fornecedor_email foreign key(cnpj) references fornecedor(cnpj) on delete cascade on update cascade
);

CREATE TABLE fornecedor_insc_estadual(
cnpj varchar(18),
insc_estadual varchar(16),
constraint fk_fornecedor_insc_estadual foreign key(cnpj) references fornecedor(cnpj) on delete cascade on update cascade
);

drop table fornecedor_insc_estadual;

create table telefone(
id int,
numero varchar(16) not null,
descricao varchar(30),
primary key(id,numero)
);

drop table telefone;


create table produto(
id int auto_increment,
tipo varchar(20) not null,
descricao text,
data_chegada date not null,
data_venda date,
primary key(id)
);

create table produto_preco(
id int not null auto_increment,
preco_custo float(5,2) not null,
preco_venda float(5,2) not null,
primary key(id)
);

create table config(
id int auto_increment,
vidro_metro_quadrado float(5,2) not null,
eucatex_metro_quadrado float(5,2) not null,
espelho_metro_quadrado float(5,2) not null,
valor_mao_de_obra float(4,1) not null,
primary key(id) 
);

create table contador_nota(
id int,
primary key(id)
);

