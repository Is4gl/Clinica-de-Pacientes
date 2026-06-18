package clinicajava;

import javax.swing.JOptionPane;

/**
 * Tela de Cadastro/Edição de Paciente.
 * Usada tanto para INSERIR quanto para ATUALIZAR.
 * Receba paciente=null para novo cadastro, ou um Paciente existente para edição.
 */
public class TelaCadastroPaciente extends javax.swing.JDialog {

    private Paciente pacienteEditando = null;
    private final PacienteDAO dao = new PacienteDAO();

    /**
     * @param parent  janela pai
     * @param paciente  null = novo cadastro | Paciente existente = edição
     */
    public TelaCadastroPaciente(java.awt.Frame parent, Paciente paciente) {
        super(parent, true);
        initComponents();
        setLocationRelativeTo(parent);

        if (paciente != null) {
            // Modo EDIÇÃO: preenche os campos
            this.pacienteEditando = paciente;
            setTitle("Editar Paciente");
            jLabelTitulo.setText("EDITAR PACIENTE");
            preencherCampos(paciente);
        } else {
            setTitle("Cadastrar Novo Paciente");
        }
    }

    private void preencherCampos(Paciente p) {
        jTextFieldNome.setText(p.getNome());
        jTextFieldCpf.setText(p.getCpf());
        jTextFieldDataNasc.setText(p.getDataNascimento());
        jTextFieldTelefone.setText(p.getTelefone());
        jTextFieldEmail.setText(p.getEmail());
        jTextFieldEndereco.setText(p.getEndereco());
        jTextAreaObservacoes.setText(p.getObservacoes());
        // selecionar convênio
        String convenio = p.getConvenio();
        if (convenio != null) {
            for (int i = 0; i < jComboBoxConvenio.getItemCount(); i++) {
                if (jComboBoxConvenio.getItemAt(i).toString().equals(convenio)) {
                    jComboBoxConvenio.setSelectedIndex(i);
                    break;
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelCpf = new javax.swing.JLabel();
        jTextFieldCpf = new javax.swing.JTextField();
        jLabelDataNasc = new javax.swing.JLabel();
        jTextFieldDataNasc = new javax.swing.JTextField();
        jLabelTelefone = new javax.swing.JLabel();
        jTextFieldTelefone = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelEndereco = new javax.swing.JLabel();
        jTextFieldEndereco = new javax.swing.JTextField();
        jLabelConvenio = new javax.swing.JLabel();
        jComboBoxConvenio = new javax.swing.JComboBox<>();
        jLabelObservacoes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaObservacoes = new javax.swing.JTextArea();
        jSeparator2 = new javax.swing.JSeparator();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Paciente");
        setModal(true);
        setResizable(false);

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("CADASTRO DE PACIENTE");

        jLabelNome.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabelNome.setText("Nome Completo: *");

        jTextFieldNome.setFont(new java.awt.Font("Tahoma", 0, 12));

        jLabelCpf.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabelCpf.setText("CPF: *");

        jTextFieldCpf.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTextFieldCpf.setToolTipText("Formato: 000.000.000-00");

        jLabelDataNasc.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabelDataNasc.setText("Data Nasc.:");

        jTextFieldDataNasc.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTextFieldDataNasc.setToolTipText("Formato: DD/MM/AAAA");

        jLabelTelefone.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabelTelefone.setText("Telefone:");

        jTextFieldTelefone.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTextFieldTelefone.setToolTipText("Formato: (00) 00000-0000");

        jLabelEmail.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabelEmail.setText("E-mail:");

        jTextFieldEmail.setFont(new java.awt.Font("Tahoma", 0, 12));

        jLabelEndereco.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabelEndereco.setText("Endereço:");

        jTextFieldEndereco.setFont(new java.awt.Font("Tahoma", 0, 12));

        jLabelConvenio.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabelConvenio.setText("Convênio:");

        jComboBoxConvenio.setFont(new java.awt.Font("Tahoma", 0, 12));
        jComboBoxConvenio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {
            "Particular", "Unimed", "Bradesco Saúde", "SulAmérica", "Amil", "Hapvida", "Notre Dame", "Outro"
        }));

        jLabelObservacoes.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabelObservacoes.setText("Observações:");
        jLabelObservacoes.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jTextAreaObservacoes.setColumns(20);
        jTextAreaObservacoes.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTextAreaObservacoes.setRows(4);
        jTextAreaObservacoes.setLineWrap(true);
        jTextAreaObservacoes.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextAreaObservacoes);

        jButtonSalvar.setBackground(new java.awt.Color(40, 150, 50));
        jButtonSalvar.setFont(new java.awt.Font("Tahoma", 1, 13));
        jButtonSalvar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalvar.setText("SALVAR");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonCancelar.setBackground(new java.awt.Color(180, 60, 60));
        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 1, 13));
        jButtonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCancelar.setText("CANCELAR");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextFieldNome))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextFieldCpf))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextFieldDataNasc))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextFieldTelefone))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextFieldEmail))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextFieldEndereco))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jComboBoxConvenio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1))
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelTitulo)
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCpf)
                    .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDataNasc)
                    .addComponent(jTextFieldDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefone)
                    .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmail)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEndereco)
                    .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelConvenio)
                    .addComponent(jComboBoxConvenio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelObservacoes)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        // Validação dos campos obrigatórios
        String nome = jTextFieldNome.getText().trim();
        String cpf = jTextFieldCpf.getText().trim();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo NOME é obrigatório!", "Atenção", JOptionPane.WARNING_MESSAGE);
            jTextFieldNome.requestFocus();
            return;
        }
        if (cpf.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo CPF é obrigatório!", "Atenção", JOptionPane.WARNING_MESSAGE);
            jTextFieldCpf.requestFocus();
            return;
        }

        // Montar objeto Paciente
        Paciente p = new Paciente();
        p.setNome(nome);
        p.setCpf(cpf);
        p.setDataNascimento(jTextFieldDataNasc.getText().trim());
        p.setTelefone(jTextFieldTelefone.getText().trim());
        p.setEmail(jTextFieldEmail.getText().trim());
        p.setEndereco(jTextFieldEndereco.getText().trim());
        p.setConvenio(jComboBoxConvenio.getSelectedItem().toString());
        p.setObservacoes(jTextAreaObservacoes.getText().trim());

        boolean sucesso;
        if (pacienteEditando == null) {
            // INSERIR novo
            sucesso = dao.inserir(p);
            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Paciente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            // ATUALIZAR existente
            p.setId(pacienteEditando.getId());
            sucesso = dao.atualizar(p);
            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Paciente atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if (sucesso) {
            dispose();
        }
    }

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxConvenio;
    private javax.swing.JLabel jLabelConvenio;
    private javax.swing.JLabel jLabelCpf;
    private javax.swing.JLabel jLabelDataNasc;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEndereco;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelObservacoes;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextAreaObservacoes;
    private javax.swing.JTextField jTextFieldCpf;
    private javax.swing.JTextField jTextFieldDataNasc;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldTelefone;
    // End of variables declaration
}
