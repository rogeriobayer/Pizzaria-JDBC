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