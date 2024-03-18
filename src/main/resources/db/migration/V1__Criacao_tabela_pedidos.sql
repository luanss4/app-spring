-- Criação da tabela "clientes"
CREATE TABLE clientes (
                          id SERIAL PRIMARY KEY,
                          nome VARCHAR(255) NOT NULL,
                          email VARCHAR(255) UNIQUE NOT NULL,
                          telefone VARCHAR(20),
                          endereco VARCHAR(255)
);

-- Criação da tabela "produtos"
CREATE TABLE produtos (
                          id SERIAL PRIMARY KEY,
                          nome VARCHAR(255) NOT NULL,
                          preco DECIMAL(10, 2) NOT NULL
);

-- Criação da tabela "pedidos"
CREATE TABLE pedidos (
                         id SERIAL PRIMARY KEY,
                         cliente_id INT REFERENCES clientes(id),
                         data_pedido DATE NOT NULL,
                         valor_total DECIMAL(10, 2) NOT NULL
);

-- Relacionamentos
ALTER TABLE pedidos ADD CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES clientes(id);

-- Scripts de inserção de dados
INSERT INTO clientes (nome, email, telefone, endereco) VALUES
                                                           ('João Silva', 'joao@email.com', '(11) 9999-1234', 'Rua A, 123'),
                                                           ('Maria Santos', 'maria@email.com', '(21) 9876-5678', 'Av. B, 456');

INSERT INTO produtos (nome, preco) VALUES
                                       ('Camiseta', 29.99),
                                       ('Calça Jeans', 59.90),
                                       ('Tênis', 79.50);

INSERT INTO pedidos (cliente_id, data_pedido, valor_total) VALUES
                                                               (1, '2024-03-15', 89.99),
                                                               (2, '2024-03-15', 139.40);
-- Adicione mais linhas conforme necessário

-- Execute o Flyway para aplicar essa migração ao banco de dados PostgreSQL
