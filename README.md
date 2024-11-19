# Biblioteca API

Projeto back-end criado para a disciplina de **Banco de Dados II**. A aplicação foi construída utilizando **Java** e **Spring Boot**, usando o **MongoDB** como o banco de dados, visando criar uma api para a consulta de informações de um projeto java pré-existente de um [Sistema de Gerenciamento de Hotel](https://github.com/Pedroo722/Hotel_PP/), desenvolvido como parte da disciplina de *Padrões de Projetos*.

Membros 
- Pedro Henrique Alexandre

## Tecnologias Usadas

<div align="center">

![Java 17](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot 3](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)

</div>

## Funcionalidades



## Estrutura dos Arquivos

- **Controllers**: Responsáveis por definir os endpoints da API.
- **Domain**: Representam as entidades do banco de dados e seus respectivos atributos.
- **Repositories**: Arquivos que fazem a conexão com o banco de dados.
- **Services**: Contêm a lógica de negócio para manipular e consultar os dados.

## Como Executar
### Pré-requisitos

- **Java 17** ou superior
- **Maven** 3.8.1+
- **MongoDB**

### Passos para execução

1. Clone o repositório:
   ```bash
   git clone https://github.com/Pedroo722/Hotel-API.git
   cd seu-repositorio
   ```

2. Compile o projeto:
   ```bash
   mvn clean install
   ```

3. Execute o projeto:
   ```bash
   mvn spring-boot:run
   ```

4. Acesse a API em: `http://localhost:8080/api/{endpoint}`.

## Endpoints
### Guest
### Reserve
### Room
### RoomType
### Service

## Estrutura dos Dados
### Guest
### Reserve
### Room
### RoomType
### Service