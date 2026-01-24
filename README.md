📚 Biblioteca API

API REST para gerenciamento de uma livraria com controle de usuários, autenticação JWT e regras de acesso por perfil, simulando um sistema real de backend.


🚀 Tecnologias utilizadas

Java 21

Spring Boot 3

Spring Security

JWT (JSON Web Token)

Spring Data JPA (Hibernate)

MySQL 8

Maven

REST API

Git & GitHub


🧠 Arquitetura do projeto

O projeto segue uma arquitetura em camadas, com separação clara de responsabilidades:

src/main/java/com/biblioteca/biblioteca_api
│
├── DTO           → Login Request
├── controllers   → Camada de entrada (REST Controllers)
├── models        → Entidades do domínio (JPA / POO)
├── repositories  → Acesso a dados (JPA Repositories)
├── services      → Regras de negócio
├── security      → JWT, filtros e configurações de segurança
└── BibliotecaApiApplication.java

Camadas

DTO (Data Transfer Object): utilizado para expor apenas os dados necessários nas requisições, como no fluxo de autenticação (email e senha), evitando o vazamento de informações internas das entidades.

Models: representam as entidades do sistema (Livro, Cliente, Usuario)

Repositories: comunicação com o banco de dados usando JPA

Services: regras de negócio e orquestração

Controllers: endpoints REST expostos pela API

Security: autenticação e autorização com JWT


🔐 Autenticação e Autorização (JWT)

A API utiliza JWT (JSON Web Token) para controle de acesso.

Fluxo de autenticação

1. O usuário faz login via endpoint /auth/login

2. A API valida as credenciais
   
3. Verifica permissões pelo ROLE

4. Um token JWT é gerado e retornado

5. O token deve ser enviado no header das requisições protegidas
    
Exemplo de login

POST /auth/login
Content-Type: application/json

{
  "email": "teste@email.com",
  "senha": "123456"
}

Uso do token

Em requisições protegidas, adicione o header:

Authorization: Bearer SEU_TOKEN_AQUI

Controle de acesso

Usuários com role CLIENTE possuem acesso restrito

Usuários com role ADMIN possuem acesso completo


📌 Funcionalidades

📚 Livros

Listar todos os livros

Buscar livro por ID

Persistência em banco de dados MySQL


👤 Clientes

Listar clientes

Buscar cliente por ID

Persistência em banco de dados MySQL


🔑 Usuários

Autenticação com e-mail e senha

Associação entre usuário e cliente

Controle de permissões por role


🌐 Endpoints principais

🔐 Autenticação

POST /auth/login → Autenticação e geração de token JWT


📚 Livros

GET /livros → Lista todos os livros

GET /livros/findbyid/{id} → Busca um livro por ID


👤 Clientes

GET /clientes → Lista todos os clientes

GET /clientes/findbyid/{id} → Busca cliente por ID


> Alguns endpoints exigem autenticação JWT


🗄️ Banco de dados

Banco: MySQL

As tabelas são geradas automaticamente pelo Hibernate

Chaves primárias com AUTO_INCREMENT

Relacionamento entre usuários e clientes via chave estrangeira


Principais tabelas

clientes

usuarios

livros

⚙️ Regras de serviço

1. Apenas usuários autenticados podem acessar endpoints protegidos
2. Controle de acesso baseado em ROLE (CLIENTE / ADMIN)
3. Associação obrigatória entre usuário e cliente
4. Validação de existência antes de buscas por ID
5. Separação entre dados expostos e entidades internas via DTO

▶️ Como executar o projeto

1. Clonar o repositório

git clone https://github.com/Gustavoindal/biblioteca-api.git

2. Configurar o banco de dados

Crie um banco no MySQL e configure o application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/livraria
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

3. Executar o projeto

mvn spring-boot:run

4. Acessar a API

http://localhost:8080


🎯 Objetivo do projeto

Este projeto tem como objetivo:

Consolidar fundamentos de Programação Orientada a Objetos

Aplicar Spring Boot em uma API REST real

Implementar autenticação JWT

Integrar Java com banco de dados relacional

Servir como projeto de portfólio para vagas de backend (estágio/júnior)


🔍 Observação

Este projeto está em constante evolução, com melhorias planejadas voltadas à escalabilidade, testes e boas práticas de produção, servindo como base para projetos backend mais complexos.

❓ Como o projeto resolve um problema real

Em sistemas reais de livrarias ou catálogos, é comum a necessidade de controle de acesso por perfil, separação entre usuários administrativos e clientes, e proteção de endpoints sensíveis. Esta API simula esse cenário utilizando autenticação JWT, controle de roles e persistência em banco relacional.


👤 Autor

Gustavo Indalêncio da Silva

Projeto desenvolvido para estudo, prática e evolução contínua no desenvolvimento backend Java.


📄 Licença

Este projeto está sob a licença MIT.
