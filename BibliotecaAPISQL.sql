use livraria;

-- INSERINDO CLIENTES
INSERT INTO clientes (nome) VALUES
('Carlos Silva'),
('Ana Pereira'),
('João Souza'),
('Mariana Costa'),
('Lucas Oliveira');

-- INSERINDO USUÁRIOS (incluindo cliente_id) 
INSERT INTO usuarios (email, password, role, cliente_id) VALUES
('carlos.silva@email.com', '$2a$12$6TpBz1aFmgFi6PDEaSaATO0NOC3YBEJeKfVrvkEQnqcA3fcVIW1QS', 'CLIENTE', 1),
('ana.pereira@email.com', '$2a$12$6TpBz1aFmgFi6PDEaSaATO0NOC3YBEJeKfVrvkEQnqcA3fcVIW1QS', 'CLIENTE', 2),
('joao.souza@email.com', '$2a$12$6TpBz1aFmgFi6PDEaSaATO0NOC3YBEJeKfVrvkEQnqcA3fcVIW1QS', 'CLIENTE', 3), -- TODOS POSSUEM A MESMA SENHA 123456 EM BCRYPT (MERAMENTE ILUSTRAÇÃO DE PROJETO)
('mariana.costa@email.com', '$2a$12$6TpBz1aFmgFi6PDEaSaATO0NOC3YBEJeKfVrvkEQnqcA3fcVIW1QS', 'CLIENTE', 4),
('lucas.oliveira@email.com', '$2a$12$6TpBz1aFmgFi6PDEaSaATO0NOC3YBEJeKfVrvkEQnqcA3fcVIW1QS', 'CLIENTE', 5);

-- INSERINDO LIVROS (com 4 colunas)
INSERT INTO livros (titulo, autor, ano_publicacao, genero) VALUES
('Dom Casmurro', 'Machado de Assis', 1899, 'Romance'),
('O Cortiço', 'Aluísio Azevedo', 1890, 'Naturalismo'),
('Capitães da Areia', 'Jorge Amado', 1937, 'Romance'),
('Grande Sertão: Veredas', 'João Guimarães Rosa', 1956, 'Regionalismo'),
('Memórias Póstumas de Brás Cubas', 'Machado de Assis', 1881, 'Romance');

SELECT * FROM usuarios;
SELECT * FROM clientes;
SELECT * FROM livros;
