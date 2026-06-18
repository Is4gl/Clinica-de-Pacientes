package clinicajava;

/**
 * Tela principal - Menu do Sistema de Clínica
 * Esta classe é gerada/editada pelo NetBeans GUI Builder.
 */
public class TelaMenu extends javax.swing.JFrame {

    public TelaMenu() {
        initComponents();
        setLocationRelativeTo(null); // centraliza na tela
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jLabelSubtitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonCadastrar = new javax.swing.JButton();
        jButtonListar = new javax.swing.JButton();
        jButtonConfiguracoes = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Clínica - Menu Principal");
        setResizable(false);

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("SISTEMA DE CLÍNICA");

        jLabelSubtitulo.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabelSubtitulo.setForeground(new java.awt.Color(80, 80, 80));
        jLabelSubtitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSubtitulo.setText("Cadastro e Gerenciamento de Pacientes");

        jButtonCadastrar.setBackground(new java.awt.Color(40, 150, 50));
        jButtonCadastrar.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButtonCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCadastrar.setText("Cadastrar Novo Paciente");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jButtonListar.setBackground(new java.awt.Color(30, 100, 180));
        jButtonListar.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButtonListar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonListar.setText("Listar / Buscar Pacientes");
        jButtonListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarActionPerformed(evt);
            }
        });

        jButtonConfiguracoes.setBackground(new java.awt.Color(80, 80, 180));
        jButtonConfiguracoes.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButtonConfiguracoes.setForeground(new java.awt.Color(255, 255, 255));
        jButtonConfiguracoes.setText("Configurar Banco de Dados");
        jButtonConfiguracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfiguracoesActionPerformed(evt);
            }
        });

        jButtonSair.setBackground(new java.awt.Color(180, 60, 60));
        jButtonSair.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButtonSair.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSair.setText("Sair do Sistema");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jLabelSubtitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(jButtonCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jButtonListar, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jButtonConfiguracoes, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jButtonSair, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelTitulo)
                .addGap(5, 5, 5)
                .addComponent(jLabelSubtitulo)
                .addGap(15, 15, 15)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButtonListar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButtonConfiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        TelaCadastroPaciente tela = new TelaCadastroPaciente(this, null);
        tela.setVisible(true);
    }

    private void jButtonListarActionPerformed(java.awt.event.ActionEvent evt) {
        TelaListaPacientes tela = new TelaListaPacientes(this);
        tela.setVisible(true);
    }

    private void jButtonConfiguracoesActionPerformed(java.awt.event.ActionEvent evt) {
        TelaConfiguracoes tela = new TelaConfiguracoes(this);
        tela.setVisible(true);
    }

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {
        int confirm = javax.swing.JOptionPane.showConfirmDialog(this,
                "Deseja realmente sair do sistema?",
                "Confirmar Saída", javax.swing.JOptionPane.YES_NO_OPTION);
        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            Conexao.fecharConexao();
            System.exit(0);
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonConfiguracoes;
    private javax.swing.JButton jButtonListar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JLabel jLabelSubtitulo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration
}
