# Controle de Produtos/Pedidos

Este projeto foi desenvolvido como parte de um desafio técnico que visa avaliar habilidades de desenvolvimento em Java e PostgreSQL. O sistema implementa um controle de produtos e pedidos, permitindo a criação, atualização, consultas e exclusão de produtos, pedidos e departamentos, além de funcionalidades relacionadas.

O projeto inclui testes unitários para garantir a qualidade do código e utiliza o PostgreSQL como banco de dados. A documentação da API está disponível via Swagger para facilitar a interação e visualização dos endpoints.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3**
- **Swagger**
- **Maven**
- **Git**
- **PostgreSQL**

## Pré-requisitos

Antes de começar, verifique se você tem as seguintes ferramentas instaladas em sua máquina:

- [Java JDK 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [PostgreSQL](https://www.postgresql.org/download/)

## Configuração Para Execução

Siga os passos abaixo para executar o projeto localmente:

### 1. Clonar o Repositório

Abra o Prompt de Comando ou PowerShell e execute:

```bash
# Clone o projeto
git clone https://github.com/chenrique13/ControleDeProdutosPedidos

# Acesse o diretório do projeto
cd ControleDeProdutosPedidos
```
### 2. Compilar o Projeto

Compile o projeto utilizando o Maven:

```bash
mvn clean install
```

### 3. Iniciar o Projeto com Configurações Padrão

Por padrão, o projeto está configurado para se conectar a um banco de dados PostgreSQL local com as seguintes informações:

- Host: localhost
- Porta: 5432
- Banco de dados: postgres
- Usuário: postgres
- Senha: 12345678
- Schema: public

Execute o seguinte comando para iniciar o projeto com essas configurações:

```bash
mvn spring-boot:run
```
Ao iniciar o projeto o sistema está configurado para popular o banco de dados para realização de testes, as informações do banco serão deletadas e inseridas com as informações das tabelas pré definidas no arquivo popularBancoControlePedidosProdutos.sql.

### 4. Sobrescrever as Configurações do Banco de Dados

Se as configurações do seu ambiente forem diferentes, você pode sobrescrever as propriedades diretamente pela linha de comando. Substitua as variáveis conforme necessário:

```bash
mvn spring-boot:run -Dspring-boot.run.arguments="
--spring.datasource.url=jdbc:postgresql://<HOST_DO_BANCO>:<PORTA_DO_BANCO>/<NOME_DO_BANCO>
--spring.datasource.username=<USUARIO_DO_BANCO>
--spring.datasource.password=<SENHA_DO_BANCO>
--spring.jpa.properties.hibernate.default_schema=<SCHEMA>"
```

### 5. Acessar a Documentação (Swagger)

Uma vez que a aplicação estiver rodando, você pode acessar a documentação da API através do Swagger no seguinte link:

[Clique aqui](http://localhost:8080/swagger-ui/index.html) ou cole esse link http://localhost:8080/swagger-ui/index.html no navegador de sua preferência.