package clinicajava;

import javax.swing.JOptionPane;

/**
 * Tela de Configurações e Teste de Conexão com o Banco de Dados.
 */
public class TelaConfiguracoes extends javax.swing.JDialog {

    public TelaConfiguracoes(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(parent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextAreaInstrucoes = new javax.swing.JTextArea();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelURL = new javax.swing.JLabel();
        jTextFieldURL = new javax.swing.JTextField();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jLabelSenha = new javax.swing.JLabel();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        jButtonTestar = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configurar Banco de Dados");
        setModal(true);
        setResizable(false);

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("CONFIGURAÇÃO DO BANCO DE DADOS");

        jTextAreaInstrucoes.setEditable(false);
        jTextAreaInstrucoes.setBackground(new java.awt.Color(220, 240, 220));
        jTextAreaInstrucoes.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTextAreaInstrucoes.setLineWrap(true);
        jTextAreaInstrucoes.setWrapStyleWord(true);
        jTextAreaInstrucoes.setText(
            "INSTRUÇÕES PARA CONFIGURAÇÃO:\n\n" +
            "1. Instale o MySQL e crie o banco usando o script em Conexao.java\n" +
            "2. Edite Conexao.java: altere URL, USUARIO e SENHA\n" +
            "3. Baixe mysql-connector-j.jar (MySQL site ou Maven)\n" +
            "4. Coloque o .jar na pasta /lib do projeto\n" +
            "5. No NetBeans: botão direito em Libraries > Add JAR/Folder\n" +
            "6. Clique em 'Testar Conexão' para verificar"
        );
        jTextAreaInstrucoes.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));

        jLabelURL.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabelURL.setText("URL do Banco:");

        jTextFieldURL.setEditable(false);
        jTextFieldURL.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTextFieldURL.setForeground(new java.awt.Color(150, 60, 60));
        jTextFieldURL.setText("jdbc:mysql://localhost:3306/clinica_db");

        jLabelUsuario.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabelUsuario.setText("Usuário MySQL:");

        jTextFieldUsuario.setEditable(false);
        jTextFieldUsuario.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTextFieldUsuario.setText("root");

        jLabelSenha.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabelSenha.setText("Senha MySQL:");

        jPasswordFieldSenha.setEditable(false);
        jPasswordFieldSenha.setFont(new java.awt.Font("Tahoma", 0, 12));
        jPasswordFieldSenha.setText("definida em Conexao.java");

        jButtonTestar.setBackground(new java.awt.Color(40, 150, 50));
        jButtonTestar.setFont(new java.awt.Font("Tahoma", 1, 13));
        jButtonTestar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonTestar.setText("Testar Conexão");
        jButtonTestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTestarActionPerformed(evt);
            }
        });

        jButtonFechar.setFont(new java.awt.Font("Tahoma", 0, 13));
        jButtonFechar.setText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jTextAreaInstrucoes)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelURL, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jTextFieldURL))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jTextFieldUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jPasswordFieldSenha))
                    .addComponent(jSeparator3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonTestar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelTitulo)
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jTextAreaInstrucoes, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelURL)
                    .addComponent(jTextFieldURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsuario)
                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSenha)
                    .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTestar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>

    private void jButtonTestarActionPerformed(java.awt.event.ActionEvent evt) {
        if (Conexao.testarConexao()) {
            JOptionPane.showMessageDialog(this,
                    "Conexão com o banco de dados realizada com SUCESSO!\n\nO sistema está pronto para uso.",
                    "Conexão OK", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    "FALHA na conexão com o banco de dados.\n\nVerifique as configurações em Conexao.java\ne se o MySQL está rodando.",
                    "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonTestar;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelURL;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea jTextAreaInstrucoes;
    private javax.swing.JTextField jTextFieldURL;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration
}
