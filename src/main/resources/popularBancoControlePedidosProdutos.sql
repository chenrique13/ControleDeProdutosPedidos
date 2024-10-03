DELETE FROM produto_pedido;
DELETE FROM Produto;
DELETE FROM Pedido;
DELETE FROM Departamento;

INSERT INTO Departamento (codigo, descricao) VALUES (1, 'Ferramentas');
INSERT INTO Departamento (codigo, descricao) VALUES (2, 'Mercado');
INSERT INTO Departamento (codigo, descricao) VALUES (3, 'Eletrônicos');

INSERT INTO Produto (codigo, descricao, preco, codigo_departamento) VALUES (1, 'Chave de Fenda', 25.00, 1);
INSERT INTO Produto (codigo, descricao, preco, codigo_departamento) VALUES (2, 'Martelo', 40.00, 1);
INSERT INTO Produto (codigo, descricao, preco, codigo_departamento) VALUES (3, 'Serrote', 60.00, 1);
INSERT INTO Produto (codigo, descricao, preco, codigo_departamento) VALUES (4, 'Alicate', 30.00, 1);
INSERT INTO Produto (codigo, descricao, preco, codigo_departamento) VALUES (5, 'Parafusadeira', 200.00, 1);

INSERT INTO Produto (codigo, descricao, preco, codigo_departamento) VALUES (6, 'Pacote de Arroz 5kg', 20.00, 2);
INSERT INTO Produto (codigo, descricao, preco, codigo_departamento) VALUES (7, 'Pacote de Feijão 1kg', 7.00, 2);
INSERT INTO Produto (codigo, descricao, preco, codigo_departamento) VALUES (8, 'Óleo de Cozinha 900ml', 10.00, 2);
INSERT INTO Produto (codigo, descricao, preco, codigo_departamento) VALUES (9, 'Leite 1L', 5.50, 2);
INSERT INTO Produto (codigo, descricao, preco, codigo_departamento) VALUES (10, 'Café 500g', 15.00, 2);

INSERT INTO Produto (codigo, descricao, preco, codigo_departamento) VALUES (11, 'Smartphone', 1500.00, 3);
INSERT INTO Produto (codigo, descricao, preco, codigo_departamento) VALUES (12, 'Notebook', 3500.00, 3);
INSERT INTO Produto (codigo, descricao, preco, codigo_departamento) VALUES (13, 'Televisão 50"', 2500.00, 3);
INSERT INTO Produto (codigo, descricao, preco, codigo_departamento) VALUES (14, 'Fone de Ouvido', 300.00, 3);
INSERT INTO Produto (codigo, descricao, preco, codigo_departamento) VALUES (15, 'Impressora', 900.00, 3);
INSERT INTO Produto (codigo, descricao, preco, codigo_departamento) VALUES (16, 'Relógio Inteligente', 600.00, 3);
INSERT INTO Produto (codigo, descricao, preco, codigo_departamento) VALUES (17, 'Teclado', 100.00, 3);
INSERT INTO Produto (codigo, descricao, preco, codigo_departamento) VALUES (18, 'Placa de Vídeo', 400.00, 3);
INSERT INTO Produto (codigo, descricao, preco, codigo_departamento) VALUES (19, 'Fone', 50.00, 3);
INSERT INTO Produto (codigo, descricao, preco, codigo_departamento) VALUES (20, 'Mouse', 120.00, 3);

INSERT INTO Pedido (numero, data) VALUES (1, '2023-01-01');
INSERT INTO Pedido (numero, data) VALUES (2, '2023-05-01');
INSERT INTO Pedido (numero, data) VALUES (3, '2023-10-01');
INSERT INTO Pedido (numero, data) VALUES (4, '2024-01-02');
INSERT INTO Pedido (numero, data) VALUES (5, '2024-05-02');
INSERT INTO Pedido (numero, data) VALUES (6, '2024-10-02');
INSERT INTO Pedido (numero, data) VALUES (7, '2025-01-03');
INSERT INTO Pedido (numero, data) VALUES (8, '2025-05-03');
INSERT INTO Pedido (numero, data) VALUES (9, '2025-10-03');

INSERT INTO produto_pedido (codigo_produto, numero_pedido, quantidade, valor_venda) VALUES (1, 1, 3, 25.00);
INSERT INTO produto_pedido (codigo_produto, numero_pedido, quantidade, valor_venda) VALUES (6, 1, 2, 20.00);
INSERT INTO produto_pedido (codigo_produto, numero_pedido, quantidade, valor_venda) VALUES (11, 2, 1, 1500.00);
INSERT INTO produto_pedido (codigo_produto, numero_pedido, quantidade, valor_venda) VALUES (10, 2, 3, 15.00);
INSERT INTO produto_pedido (codigo_produto, numero_pedido, quantidade, valor_venda) VALUES (17, 2, 2, 100.00);
INSERT INTO produto_pedido (codigo_produto, numero_pedido, quantidade, valor_venda) VALUES (5, 3, 1, 200.00);
INSERT INTO produto_pedido (codigo_produto, numero_pedido, quantidade, valor_venda) VALUES (12, 3, 1, 3500.00);
INSERT INTO produto_pedido (codigo_produto, numero_pedido, quantidade, valor_venda) VALUES (19, 3, 4, 50.00);
INSERT INTO produto_pedido (codigo_produto, numero_pedido, quantidade, valor_venda) VALUES (7, 4, 5, 7.00);
INSERT INTO produto_pedido (codigo_produto, numero_pedido, quantidade, valor_venda) VALUES (13, 4, 1, 2500.00);
INSERT INTO produto_pedido (codigo_produto, numero_pedido, quantidade, valor_venda) VALUES (2, 5, 2, 40.00);
INSERT INTO produto_pedido (codigo_produto, numero_pedido, quantidade, valor_venda) VALUES (15, 5, 1, 900.00);
INSERT INTO produto_pedido (codigo_produto, numero_pedido, quantidade, valor_venda) VALUES (16, 6, 2, 600.00);
INSERT INTO produto_pedido (codigo_produto, numero_pedido, quantidade, valor_venda) VALUES (18, 7, 3, 400.00);
INSERT INTO produto_pedido (codigo_produto, numero_pedido, quantidade, valor_venda) VALUES (9, 7, 10, 5.50);
INSERT INTO produto_pedido (codigo_produto, numero_pedido, quantidade, valor_venda) VALUES (4, 8, 7, 30.00);
INSERT INTO produto_pedido (codigo_produto, numero_pedido, quantidade, valor_venda) VALUES (3, 8, 4, 60.00);
INSERT INTO produto_pedido (codigo_produto, numero_pedido, quantidade, valor_venda) VALUES (8, 9, 15, 10.00);
INSERT INTO produto_pedido (codigo_produto, numero_pedido, quantidade, valor_venda) VALUES (14, 9, 5, 300.00);
