# 📓 A3 - Sistema de Registros (Diário Pessoal)

> Um sistema desktop estilo diário para registrar, consultar e armazenar anotações e acontecimentos do dia a dia.

![Status do Projeto](https://img.shields.io/badge/Status-Concluído-success)
![Linguagem](https://img.shields.io/badge/Java-ED8B00?logo=java&logoColor=white)
![Banco de Dados](https://img.shields.io/badge/MySQL-4479A1?logo=mysql&logoColor=white)

## 💻 Sobre o Projeto

O **Sistema de Registros** é uma aplicação desktop desenvolvida como trabalho em grupo (Avaliação A3) com o objetivo de aplicar conceitos de Programação Orientada a Objetos (POO) e integração com Banco de Dados Relacional.

O aplicativo funciona como um diário digital. O usuário pode escrever relatos, pensamentos ou anotações importantes e o sistema se encarrega de salvar a data exata e o conteúdo inserido. É um projeto prático que demonstra a capacidade de criar interfaces gráficas (GUI) em Java e realizar operações de CRUD (Create, Read, Update, Delete) no banco de dados.

## 🚀 Principais Funcionalidades

* **Registro Diário:** Inserção de novos textos e anotações.
* **Captura de Data:** O sistema vincula automaticamente (ou via input) o texto à data do registro.
* **Histórico de Registros:** Consulta de entradas anteriores armazenadas no banco de dados.
* **Interface Gráfica (GUI):** Telas interativas para facilitar a navegação e o uso do sistema.

## 🛠️ Tecnologias e Conceitos Utilizados

Este projeto uniu o ecossistema Java com banco de dados para garantir a persistência das informações a longo prazo.

**Tecnologias:**
* **Java:** Linguagem principal utilizada para a lógica da aplicação.
* **Java Swing:** Utilizada para a construção da Interface Gráfica do Usuário.
* **MySQL:** Banco de dados relacional para armazenar os textos e datas.
* **JDBC (Java Database Connectivity):** API utilizada para fazer a conexão e enviar os comandos SQL do Java para o MySQL.

**Conceitos Aplicados:**
* Programação Orientada a Objetos (POO).
* Padrão de Arquitetura (MVC).
* Operações CRUD em Banco de Dados.
* Trabalho em equipe e versionamento de código.

## ⚙️ Como Executar o Projeto na sua Máquina

Para rodar este projeto, você precisará do [Java JDK](https://www.oracle.com/java/technologies/downloads/) instalado e de um servidor MySQL (como XAMPP, MySQL Workbench ou Docker).

### Configurando o Banco de Dados
1. Abra o seu gerenciador do MySQL.
2. Crie um banco de dados para o projeto.
3. *(Se houver um arquivo .sql no repositório)*: Execute o script SQL disponível na pasta `database` (ou similar) para criar as tabelas necessárias.
4. Verifique as credenciais de acesso (usuário e senha do banco) dentro da classe de conexão no código Java e altere para as credenciais da sua máquina local, se necessário.

### Rodando a Aplicação
1. Clone o repositório:
```bash
git clone [https://github.com/kekeu0/A3-Sistema-de-Registros.git](https://github.com/kekeu0/A3-Sistema-de-Registros.git)
