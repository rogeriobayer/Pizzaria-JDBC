-- clientes definition

CREATE TABLE `clientes` (
  `id` varchar(100) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `sobrenome` varchar(100) DEFAULT NULL,
  `telefone` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `clientes_UN` (`telefone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- sabores definition

CREATE TABLE `sabores` (
  `id` varchar(100) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `tipo` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- tipo_pizza definition

CREATE TABLE `tipo_pizza` (
  `id` int NOT NULL,
  `nome` varchar(100) NOT NULL,
  `preco` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- pedidos definition

CREATE TABLE `pedidos` (
  `id` varchar(100) NOT NULL,
  `id_cliente` varchar(100) NOT NULL,
  `preco` double NOT NULL,
  `estado` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pk_cliente` (`id_cliente`),
  CONSTRAINT `pk_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- pizzas definition

CREATE TABLE `pizzas` (
  `id` varchar(100) NOT NULL,
  `id_pedido` varchar(100) NOT NULL,
  `id_sabor1` varchar(100) NOT NULL,
  `id_sabor2` varchar(100) DEFAULT NULL,
  `forma` int DEFAULT NULL,
  `area` double DEFAULT NULL,
  `raio` double DEFAULT NULL,
  `centimetro_quadrado` tinyint(1) DEFAULT NULL,
  `preco` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pk_pedido` (`id_pedido`),
  KEY `pk_sabor1` (`id_sabor1`),
  KEY `pk_sabor2` (`id_sabor2`),
  CONSTRAINT `pk_pedido` FOREIGN KEY (`id_pedido`) REFERENCES `pedidos` (`id`),
  CONSTRAINT `pk_sabor1` FOREIGN KEY (`id_sabor1`) REFERENCES `sabores` (`id`),
  CONSTRAINT `pk_sabor2` FOREIGN KEY (`id_sabor2`) REFERENCES `sabores` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO tipo_pizza
(id, nome, preco)
VALUES(0, 'Simples', 500.0);
INSERT INTO tipo_pizza
(id, nome, preco)
VALUES(1, 'Especial', 5.52);
INSERT INTO tipo_pizza
(id, nome, preco)
VALUES(2, 'Premium', 2.0);
