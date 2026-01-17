📚 Biblioteca API
API REST para gerenciamento de livros, clientes e usuários, desenvolvida com Spring Boot, JPA (Hibernate), MySQL e autenticação JWT.
O projeto aplica conceitos sólidos de Programação Orientada a Objetos, arquitetura em camadas, segurança com Spring Security e integração com banco de dados relacional.

🚀 Tecnologias utilizadas
Java 21
Spring Boot 3
Spring Security
JWT (JSON Web Token)
Spring Data JPA (Hibernate)
MySQL
Maven
REST API
Git & GitHub

🧠 Arquitetura do projeto
O projeto segue uma separação clara de responsabilidades, baseada em arquitetura em camadas:
Copiar código

src/main/java/com/biblioteca/biblioteca_api
│
├── controller    → Camada de entrada (REST Controllers)
├── models        → Entidades do domínio (POO)
├── repositories  → Acesso a dados (JPA Repositories)
├── services      → Regras de negócio
├── security      → Configuração de segurança e JWT
└── BibliotecaApiApplication.java
Camadas
Models: entidades do sistema (Livro, Cliente, Usuario)
Repositories: comunicação com o banco via JPA
Services: lógica de negócio e orquestração
Controllers: endpoints REST
Security: autenticação, autorização e geração/validação de tokens JWT

🔐 Segurança e Autenticação
A API utiliza JWT (JSON Web Token) para autenticação stateless.
Fluxo de autenticação:
O usuário realiza login (/auth/login)
A API valida as credenciais
Um token JWT é gerado
O token deve ser enviado no header das requisições protegidas:
Copiar código

Authorization: Bearer <token>
Controle de acesso por role:
ADMIN
Acesso completo à API
CLIENTE
Acesso restrito (ex: visualização de livros)

📌 Funcionalidades

📚 Livros
Listar livros
Buscar livro por ID
Persistência em banco MySQL

👤 Clientes
Listar clientes
Buscar cliente por ID
Relacionamento com usuários

🔑 Usuários
Autenticação com e-mail e senha
Senhas armazenadas com BCrypt
Associação entre usuário e cliente
Autorização baseada em roles

🌐 Endpoints principais
🔐 Autenticação
POST /auth/login → Gera token JWT
📚 Livros
GET /livros → Lista todos os livros (requer autenticação)
GET /livros/findbyid{id} → Busca livro por ID
👤 Clientes
GET /clientes → Lista clientes (ADMIN)
GET /clientes/findbyid{id} → Busca cliente por ID

🗄️ Banco de dados
Banco: MySQL
As tabelas são geradas automaticamente pelo Hibernate
Chaves primárias com AUTO_INCREMENT
Relacionamento entre:
usuarios
clientes
livros
Scripts SQL de exemplo estão disponíveis para carga inicial de dados.

▶️ Como executar o projeto
1️⃣ Clone o repositório
Copiar código
Bash
git clone https://github.com/GustavoIndal/biblioteca-api.git
2️⃣ Configure o banco de dados
Ajuste o arquivo application.properties com suas credenciais do MySQL.
3️⃣ Execute o projeto
Copiar código
Bash
mvn spring-boot:run
4️⃣ Acesse a aplicação
Copiar código

http://localhost:8080

🧪 Testes
Os endpoints foram testados utilizando Postman, incluindo:
Login e geração de JWT
Requisições autenticadas com Bearer Token
Testes de acesso por role (ADMIN / CLIENTE)

🎯 Objetivo do projeto
Este projeto tem como objetivo:
Consolidar fundamentos de POO
Desenvolver uma API REST segura
Aplicar Spring Security + JWT
Integrar Java com banco de dados relacional
Servir como projeto de portfólio para estágios e posições júnior em backend

🧩 Observações
Projeto em constante evolução, focado no aprendizado prático de:
Arquitetura backend
Segurança em APIs REST
Boas práticas com Spring Boot

👤Autor: Gustavo Indalêncio da Silva.
