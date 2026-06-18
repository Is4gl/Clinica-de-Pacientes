package clinicajava;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 * Classe responsável pela conexão com o banco de dados MySQL.
 * ============================================================
 * CONFIGURAÇÃO DO BANCO DE DADOS:
 * 1. Crie o banco no MySQL com o script abaixo
 * 2. Altere os campos URL, USUARIO e SENHA conforme seu ambiente
 * 3. Adicione o mysql-connector-j.jar na pasta /lib do projeto
 * ============================================================
 *
 * SCRIPT SQL - execute no MySQL Workbench ou phpMyAdmin:
 *
 * CREATE DATABASE clinica_db;
 * USE clinica_db;
 *
 * CREATE TABLE pacientes (
 *   id INT AUTO_INCREMENT PRIMARY KEY,
 *   nome VARCHAR(100) NOT NULL,
 *   cpf VARCHAR(14) NOT NULL UNIQUE,
 *   data_nascimento VARCHAR(10),
 *   telefone VARCHAR(20),
 *   email VARCHAR(100),
 *   endereco VARCHAR(200),
 *   convenio VARCHAR(100),
 *   observacoes TEXT,
 *   data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
 * );
 */
public class Conexao {

    // ======== ALTERE AQUI AS CONFIGURAÇÕES DE CONEXÃO ========
    private static final String URL = "jdbc:mysql://localhost:3306/clinica_db";
    private static final String USUARIO = "root";
    private static final String SENHA = ""; // coloque sua senha aqui
    // =========================================================

    private static Connection conexao = null;

    public static Connection getConexao() {
        try {
            if (conexao == null || conexao.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            }
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                "Driver MySQL não encontrado!\n\n" +
                "Adicione o arquivo mysql-connector-j.jar\n" +
                "na pasta /lib do projeto e configure\n" +
                "nas Libraries do NetBeans.",
                "Erro de Driver", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Erro ao conectar com o banco de dados!\n\n" +
                "Verifique em Conexao.java:\n" +
                "- URL: " + URL + "\n" +
                "- Usuário: " + USUARIO + "\n" +
                "- Senha configurada\n\n" +
                "Detalhe: " + e.getMessage(),
                "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
        }
        return conexao;
    }

    public static void fecharConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                conexao = null;
            }
        } catch (Exception e) {
            System.err.println("Erro ao fechar conexão: " + e.getMessage());
        }
    }

    public static boolean testarConexao() {
        Connection c = getConexao();
        return c != null;
    }
}
