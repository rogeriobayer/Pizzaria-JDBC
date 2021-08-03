CREATE TABLE clientes(
id varchar(100) NOT NULL,
nome varchar(100) NOT NULL,
sobrenome varchar(100) NOT NULL,
telefone varchar(100) NOT NULL,
constraint pk_cliente PRIMARY KEY (id)
);


CREATE TABLE sabores(
id varchar(100) NOT NULL,
nome varchar(100) NOT NULL,
tipo int NOT NULL,
 constraint fk_sabores PRIMARY KEY (id)
 constraint fk_tipo foreign key(tipo) references tipo_pizza(id)
);

CREATE TABLE tipo_pizza(
id integer NOT NULL,
nome varchar(100) NOT NULL,
preco double NOT NULL,
constraint pk_tipoPizza PRIMARY KEY (id)
);

INSERT INTO tipo_pizza 
VALUES (0, "Simples", 0);
INSERT INTO tipo_pizza 
VALUES (1, "Especial", 1);
INSERT INTO tipo_pizza 
VALUES (2, "Premium", 2);


CREATE TABLE pedidos(
id varchar(100) NOT NULL,
id_cliente varchar(100) NOT NULL,
preço  double NOT NULL,
estado varchar(100), -- ABERTO = 0; A_CAMINHO = 1; ENTREGUE = 2;
-- forma integer not null,
-- preco double NOT NULL,
constraint pk_tipoPizza PRIMARY KEY (id),
 constraint pk_cliente foreign key(id_cliente) references clientes(id)

)

CREATE TABLE pizzas(
id varchar(100) NOT NULL,
id_pedido varchar(100) NOT NULL,
nome varchar(100) NOT NULL,
id_sabor1 varchar(100) NOT NULL,
id_sabor2 varchar(100),
forma integer not null, 
area double,
raio double,
centimetro_quadrado integer, 
preco double NOT NULL,
constraint pk_pizza PRIMARY KEY (id),
 constraint pk_pedido foreign key(id_pedido) references pedidos(id),
 constraint pk_sabor1 foreign key(id_sabor1) references sabores(id),
 constraint pk_sabor2 foreign key(id_sabor2) references sabores(id)

);
  

CREATE TABLE livro
(id int(4) AUTO_INCREMENT,
titulo varchar(45),
constraint pk_Livro PRIMARY KEY (id));

CREATE TABLE Livro_Autor
(idLivro int(4),
idAutor int(4),
constraint pk_LivroAutor primary key(idLivro, idAutor),
constraint fk_LivroAutor_pk_Livro foreign key(idLivro) references livro(id) on update cascade,
constraint fk_LivroAutor_pk_Autor foreign key(idAutor) references autor(id) on update cascade);