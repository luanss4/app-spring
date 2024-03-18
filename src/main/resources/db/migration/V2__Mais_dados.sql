-- Inserção de dados na tabela "clientes"
INSERT INTO clientes (nome, email, telefone, endereco) VALUES
                                                           ('Ana Oliveira', 'ana@email.com', '(31) 9876-5432', 'Rua C, 789'),
                                                           ('Carlos Santos', 'carlos@email.com', '(41) 5555-1234', 'Av. D, 1010'),
                                                           ('Eduarda Lima', 'eduarda@email.com', '(21) 7777-9876', 'Praça E, 2222');

-- Inserção de dados na tabela "produtos"
INSERT INTO produtos (nome, preco) VALUES
                                       ('Shorts', 39.99),
                                       ('Vestido', 79.90),
                                       ('Sandália', 49.50),
                                       ('Camisa Polo', 59.99);

-- Inserção de dados na tabela "pedidos"
INSERT INTO pedidos (cliente_id, data_pedido, valor_total) VALUES
                                                               (1, '2024-03-15', 119.89),
                                                               (2, '2024-03-15', 139.40),
                                                               (3, '2024-03-15', 89.50);
-- Adicione mais linhas conforme necessário
