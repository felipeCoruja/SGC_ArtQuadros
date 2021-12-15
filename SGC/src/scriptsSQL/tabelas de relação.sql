create table nota_cliente(
id_cliente int not null,
id_nota int not null,
constraint fk_cliente_id foreign key(id_cliente) references cliente_nome(id) on delete cascade on update cascade,
constraint fk_nota_id foreign key(id_nota) references nota(id) on delete cascade on update cascade
);


create table nota_pedido(
id_nota int not null,
id_pedido int not null,
constraint fk_nota_id2 foreign key(id_nota) references nota(id) on delete cascade on update cascade,
constraint fk_pedido_id foreign key(id_pedido) references pedido(id) on delete cascade on update cascade
);


create table pedido_moldura(
id_pedido int not null,
id_moldura varchar(20) not null,
ordem_moldura_paspatu tinyint not null default '1',
constraint fk_pedido_id2 foreign key(id_pedido) references pedido(id) on delete cascade on update cascade,
constraint fk_moldura_id foreign key(id_moldura) references moldura(id) on delete cascade on update cascade
);


use bd_artquadros;
desc pedido_vidro;

create table pedido_vidro(
id_pedido int not null,
id_vidro int not null,
entre_vidros enum ('S','N') default 'N' not null,
constraint fk_pedido_id3 foreign key(id_pedido) references pedido(id) on delete cascade on update cascade,
constraint fk_vidro_id foreign key(id_vidro) references vidro(id) on delete cascade on update cascade
);

create table pedido_eucatex(
id_eucatex int not null,
id_pedido int not null,
constraint fk_eucatex_id foreign key(id_eucatex) references eucatex(id) on delete cascade on update cascade,
constraint fk_pedido_id4 foreign key(id_pedido) references pedido(id) on delete cascade on update cascade
);

create table moldura_fornecedor(
id_moldura varchar(20) not null,
id_fornecedor varchar(18) not null,
constraint fk_moldura_id2 foreign key(id_moldura) references moldura(id) on delete cascade on update cascade,
constraint fk_fornecedor_id foreign key(id_fornecedor) references fornecedor(cnpj) on delete cascade on update cascade
);



create table vidro_fornecedor(
id_vidro int not null,
id_fornecedor varchar(18) not null,
constraint fk_vidro_id2 foreign key(id_vidro) references vidro(id) on delete cascade on update cascade,
constraint fk_fornecedor_id2 foreign key(id_fornecedor) references fornecedor(cnpj) on delete cascade on update cascade
);

create table eucatex_fornecedor(
id_eucatex int not null,
id_fornecedor varchar(18) not null,
constraint fk_eucatex_id2 foreign key(id_eucatex) references eucatex(id) on delete cascade on update cascade,
constraint fk_fornecedor_id3 foreign key(id_fornecedor) references fornecedor(cnpj) on delete cascade on update cascade
);

create table produto_eucatex(
id_produto int not null,
id_eucatex int not null,
constraint fk_produto_id foreign key(id_produto) references produto(id) on delete cascade on update cascade,
constraint fk_eucatex_id3 foreign key(id_eucatex) references eucatex(id) on delete cascade on update cascade
);

create table produto_vidro(
id_produto int not null,
id_vidro int not null,
constraint fk_produto_id2 foreign key(id_produto) references produto(id) on delete cascade on update cascade,
constraint fk_vidro_id3 foreign key(id_vidro) references vidro(id) on delete cascade on update cascade
);

create table produto_moldura(
id_produto int not null,
id_moldura varchar(20) not null,
constraint fk_produto_id3 foreign key(id_produto) references produto(id) on delete cascade on update cascade,
constraint fk_moldura_id3 foreign key(id_moldura) references moldura(id) on delete cascade on update cascade
);



create table produto_fornecedor(
id_produto int not null,
id_fornecedor varchar(18) not null,
constraint fk_produto_id4 foreign key(id_produto) references produto(id) on delete cascade on update cascade,
constraint fk_fornecedor_id4 foreign key(id_fornecedor) references fornecedor(cnpj) on delete cascade on update cascade
);

create table cliente_endereco(
idCliente int not null,
idEndereco int not null,
constraint fk_cliente_id2 foreign key(idCliente) references cliente_nome(id) on delete cascade on update cascade,
constraint fk_endereco_id foreign key(idEndereco) references endereco(id) on delete cascade on update cascade
);

create table fornecedor_endereco(
idFornecedor varchar(18) not null,
idEndereco int not null,
constraint fk_fornecedor_id5 foreign key(idFornecedor) references fornecedor(cnpj) on delete cascade on update cascade,
constraint fk_endereco_id2 foreign key(idEndereco) references endereco(id) on delete cascade on update cascade
);
