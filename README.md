# 🏥 Sistema de Clínica — Cadastro de Pacientes

Sistema desktop desenvolvido em **Java** com interface gráfica **Swing/JFrame** e banco de dados **MySQL**, voltado ao gerenciamento de pacientes em clínicas médicas com controle de acesso por usuários autenticados.

---

## 📋 Funcionalidades

- **Login** com autenticação de usuário validada no banco de dados
- **Cadastrar** novos pacientes com informações completas
- **Listar** todos os pacientes em tabela organizada
- **Buscar** pacientes por nome em tempo real
- **Editar** dados de um paciente já cadastrado
- **Excluir** paciente com confirmação de segurança
- **Testar conexão** com o banco de dados diretamente pela interface

---

## 🔐 Controle de Acesso e Usuários

O sistema utiliza autenticação com login e senha validados diretamente no banco de dados. Existem dois níveis de acesso:

| Perfil | Quem é | O que pode fazer |
|--------|--------|-----------------|
| **Administrador** | Responsável técnico / DBA | Acesso total ao sistema e ao banco |
| **Usuário comum** | Recepcionista, atendente | Login e uso do sistema (CRUD de pacientes) |

### Regra de negócio importante

> **Novos usuários só podem ser cadastrados diretamente no banco de dados**, por um administrador ou desenvolvedor back-end com acesso ao MySQL. Não existe tela de auto-cadastro no sistema — isso é intencional e garante que apenas pessoas autorizadas tenham acesso.

Para cadastrar um novo usuário, o administrador executa diretamente no banco:

```sql
INSERT INTO usuarios (nome, login, senha, perfil)
VALUES ('Nome do Funcionário', 'login_escolhido', MD5('senha_escolhida'), 'usuario');
```

Para cadastrar um administrador:

```sql
INSERT INTO usuarios (nome, login, senha, perfil)
VALUES ('Nome do Admin', 'admin', MD5('senha_segura'), 'admin');
```

> A senha é armazenada com hash **MD5**. Nunca armazene senhas em texto puro.

---

## 🖥️ Telas do Sistema

| Tela | Descrição |
|------|-----------|
| **Login** | Autenticação do usuário antes de qualquer acesso |
| **Menu Principal** | Ponto de entrada com acesso a todas as funcionalidades |
| **Cadastro de Paciente** | Formulário completo para inserção e edição |
| **Lista de Pacientes** | Tabela com busca, edição e exclusão |
| **Configurações** | Informações de conexão e teste do banco |

---

## 🗂️ Estrutura do Projeto

```
ClinicaJava/
├── src/clinicajava/
│   ├── Main.java                          ← Ponto de entrada do sistema
│   ├── Conexao.java                       ← Configuração do MySQL ⚠️
│   ├── Paciente.java                      ← Modelo de dados - paciente
│   ├── Usuario.java                       ← Modelo de dados - usuário
│   ├── PacienteDAO.java                   ← CRUD de pacientes
│   ├── UsuarioDAO.java                    ← Autenticação de usuários
│   ├── TelaLogin.java / .form             ← Tela de login
│   ├── TelaMenu.java / .form              ← Menu principal
│   ├── TelaCadastroPaciente.java / .form  ← Cadastro e edição
│   ├── TelaListaPacientes.java / .form    ← Lista com busca
│   └── TelaConfiguracoes.java / .form     ← Configuração do banco
├── lib/                                   ← Driver JDBC do MySQL
├── banco_de_dados.sql                     ← Script de criação do banco
└── LEIA-ME.txt                            ← Instruções detalhadas
```

---

## ⚙️ Pré-requisitos

- Java JDK 8 ou superior
- MySQL 5.7 ou superior
- Driver JDBC: `mysql-connector-j` (`.jar`)

---

## 🚀 Como Configurar e Executar

### 1. Criar o banco de dados

Execute o arquivo `banco_de_dados.sql` no seu gerenciador MySQL (Workbench, DBeaver, phpMyAdmin, etc.):

```sql
CREATE DATABASE clinica_db;
USE clinica_db;

CREATE TABLE pacientes (
    id               INT AUTO_INCREMENT PRIMARY KEY,
    nome             VARCHAR(100) NOT NULL,
    cpf              VARCHAR(14) NOT NULL UNIQUE,
    data_nascimento  VARCHAR(10),
    telefone         VARCHAR(20),
    email            VARCHAR(100),
    endereco         VARCHAR(200),
    convenio         VARCHAR(100),
    observacoes      TEXT,
    data_cadastro    TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE usuarios (
    id        INT AUTO_INCREMENT PRIMARY KEY,
    nome      VARCHAR(100) NOT NULL,
    login     VARCHAR(50) NOT NULL UNIQUE,
    senha     VARCHAR(255) NOT NULL,
    perfil    ENUM('admin', 'usuario') DEFAULT 'usuario',
    ativo     TINYINT(1) DEFAULT 1,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Usuário administrador padrão (senha: admin123)
INSERT INTO usuarios (nome, login, senha, perfil)
VALUES ('Administrador', 'admin', MD5('admin123'), 'admin');
```

### 2. Configurar a conexão

Edite o arquivo `src/clinicajava/Conexao.java` e ajuste as três constantes:

```java
private static final String URL     = "jdbc:mysql://localhost:3306/clinica_db";
private static final String USUARIO = "root";
private static final String SENHA   = "sua_senha_aqui";
```

### 3. Adicionar o driver JDBC

Baixe o `mysql-connector-j-X.X.X.jar` em [dev.mysql.com/downloads/connector/j](https://dev.mysql.com/downloads/connector/j), coloque na pasta `/lib` do projeto e adicione ao classpath do seu ambiente de desenvolvimento.

### 4. Compilar e executar

```bash
# Via terminal (na raiz do projeto)
javac -cp lib/mysql-connector-j-8.0.33.jar -d build/classes src/clinicajava/*.java
java -cp build/classes:lib/mysql-connector-j-8.0.33.jar clinicajava.Main
```

---

## 🗃️ Campos do Cadastro de Paciente

| Campo | Obrigatório | Descrição |
|-------|-------------|-----------|
| Nome Completo | ✅ Sim | Nome do paciente |
| CPF | ✅ Sim | Formato: `000.000.000-00` (único) |
| Data de Nascimento | Não | Formato: `DD/MM/AAAA` |
| Telefone | Não | Formato: `(00) 00000-0000` |
| E-mail | Não | Endereço de e-mail |
| Endereço | Não | Endereço residencial |
| Convênio | Não | Seleção em lista (Particular, Unimed, etc.) |
| Observações | Não | Anotações clínicas livres |

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Uso |
|------------|-----|
| Java 8 | Linguagem principal |
| Java Swing (JFrame) | Interface gráfica |
| JDBC | Comunicação com o banco |
| MySQL | Banco de dados relacional |
| MD5 | Hash de senhas dos usuários |
| GroupLayout | Gerenciador de layout das telas |

---

## 📌 Observações

- A classe `Conexao.java` centraliza toda a configuração do banco — edite apenas ela para mudar o ambiente.
- A classe `PacienteDAO.java` e `UsuarioDAO.java` concentram as operações de banco, seguindo o padrão **DAO (Data Access Object)**.
- Todos os erros de conexão e SQL são exibidos em caixas de diálogo amigáveis ao usuário final.
- Um usuário desativado (`ativo = 0`) no banco não consegue fazer login, sem necessidade de excluir o registro.

---

## 👨‍💻 Padrão de Arquitetura

```
Telas (View)  →  DAO (Acesso a Dados)  →  MySQL (Banco)
      ↕
  Modelos (Paciente.java / Usuario.java)
```

O fluxo de autenticação segue este caminho:

```
TelaLogin  →  UsuarioDAO.autenticar()  →  Tabela usuarios (MySQL)
    ↓ (login válido)
 TelaMenu  →  demais funcionalidades do sistema
```

---

*Projeto acadêmico — Sistema de Clínica com CRUD de Pacientes e autenticação de usuários em Java Swing.*
