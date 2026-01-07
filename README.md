API REST para gerenciamento de livros e clientes, desenvolvida com Spring Boot, JPA (Hibernate)* e MySQL.  
O projeto aplica conceitos sólidos de *Programação Orientada a Objetos*, arquitetura em camadas e integração com banco de dados relacional.

🚀 Tecnologias utilizadas

- Java 21  
- Spring Boot 3  
- Spring Data JPA (Hibernate)  
- MySQL  
- Maven  
- REST API  
- Git & GitHub  

🧠 Arquitetura do projeto

O projeto segue uma separação clara de responsabilidades:
src/main/java/primeira_api │ ├── controller     → Camada de entrada (REST Controllers) ├── models → Entidades do domínio (POO) ├── repositories → Acesso a dados (JPA Repositories) ├── services → Lógica de negócio └── PrimeiraApiApplication.java
Copiar código

Camadas:
- *Models*: representam as entidades do sistema (Livro, Cliente)
- *Repositories*: comunicação com o banco de dados usando JPA
- *Services*: regras de negócio e orquestração
- *Controllers*: endpoints REST expostos pela API

📌 Funcionalidades

### Livros
- Listar livros
- Buscar livro por ID
- Persistência em banco de dados MySQL

Clientes
- Listar clientes
- Buscar cliente por ID
- Persistência em banco de dados MySQL

🌐 Endpoints principais

📚 Livros
- GET /livros → Lista todos os livros
- GET /livros/{id} → Busca um livro por ID

👤 Clientes
- GET /clientes → Lista todos os clientes
- GET /clientes/{id} → Busca um cliente por ID

🗄️ Banco de dados

- Banco: MySQL
- As tabelas são geradas automaticamente pelo Hibernate
- Mapeamento feito via JPA

Exemplo de entidades:
- livros
- clientes

▶️ Como executar o projeto

1. Clone o repositório:

git clone https://github.com/GustavoIndal/biblioteca-api.git
Configure o banco MySQL e ajuste o application.properties
Execute o projeto
Copiar código
mvn spring-boot:run
Acesse:

http://localhost:8080

🎯 Objetivo do projeto

Este projeto tem como objetivo:
Consolidar fundamentos de POO
Aplicar Spring Boot em uma API REST real
Integrar Java com banco de dados relacional
Servir como projeto de portfólio para estágios em backend

👤 Autor

Gustavo Indalêncio da Silva
Estudante de Desenvolvimento de Sistemas
Foco em Backend • Java • POO • APIs REST
