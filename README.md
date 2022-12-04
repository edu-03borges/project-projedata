# Sistema Funcionários 

**OBS**: Eu entendo da necessidade de realizar apenas os procedimentos que foram pedidos nesse contexto/teste, mas me vejo na obrigação de realizar algo mais para poder me destacar dos demais candidatos e por esse motivo eu resolvi implementar um banco de dados integrado no software de teste. Mas mesmo assim eu segui a risca todos os passos pedidos pelo teste de integração. Não tenho a obrigação de agradar ninguém, mas sim conquistar uma vaga nesta empresa. Obrigado desde já.

## Índice

* [1. Sobre o projeto](#1-sobre-o-projeto)
* [2. Funcionalidades da aplicação](#2-funcionalidades-da-aplicação)
* [3. Uso](#3-uso)
* [4. Visualização](#4-Visualização)
* [5. Ferramentas Utilizadas](#5-ferramentas-utilizadas)

***

## 1. Sobre o projeto

Aplicação desenvolvida para controle e consulta de funcionários.
Para isso foi criado um banco de dados no MySQL e JAVA.

## 2. Funcionalidades da aplicação
As funcionalidades disponibilizadas ao usuário são:

* Consulta, edição e exclusão de cargos;
* Cadastro de Funcionários;
* Consulta, edição e exclusão de funcionários;
* Apresentaçáo de relatórios de cargos e salários.

Ao desenvolver cada funcionalidade, foram desenvolvidos critérios que deveriam ser cumpridos para atender a _definição de pronto_.

## 3. Uso
Para visualização dessa aplicação, você deverá ter instalado o JVM e criar o seu próprio banco de dados MYSQL.

Para conectar o seu Banco de Dados com o projeto, você deverá alterar o arquivo *Main.java*, que se encontra na pasta src/main/java/main/Main.java, e inserir *usuário* e *senha*.

### Banco de Dados

O banco de dados deverá ter o nome de *sistema_de_funcionarios*

A tabela FUNCIONÁRIOS deverá se chamar *funcionarios* e deverá ser criada com as definições do exemplo abaixo.

```
create table funcionarios (
    id int primary key auto_increment,
    name varchar(50) not null,
    birth_date DATE not null,
    wage varchar(255) not null,
    employee_position varchar(50) not null
);
```

## 4. Visualização

Para a execução basicamente depois de tudo configurado você deve apenas iniciar a aplicação no eclipse apertando em run por exemplo e seguir visualizando o terminal do  eclipse e seguir realizando o passo a passo que é prescrito.

## 5. Ferramentas utilizadas

Para desenvolver essa aplicação, utilizamos as seguintes ferramentas:

* JAVA
* MySQL
* Eclipse
* GIT
* GitHub

