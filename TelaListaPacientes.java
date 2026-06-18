package clinicajava;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Tela de Listagem, Busca, Edição e Exclusão de Pacientes.
 * Exibe uma JTable com todos os pacientes e botões de CRUD.
 */
public class TelaListaPacientes extends javax.swing.JFrame {

    private final PacienteDAO dao = new PacienteDAO();
    private List<Paciente> listaPacientes;
    private final java.awt.Frame parent;

    public TelaListaPacientes(java.awt.Frame parent) {
        this.parent = parent;
        initComponents();
        setLocationRelativeTo(parent);
        configurarTabela();
        carregarTodos();
    }

    private void configurarTabela() {
        // Define os cabeçalhos da tabela
        String[] colunas = {"ID", "Nome", "CPF", "Data Nasc.", "Telefone", "E-mail", "Convênio"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Tabela somente leitura
            }
        };
        jTablePacientes.setModel(modelo);

        // Ajustar largura das colunas
        jTablePacientes.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTablePacientes.getColumnModel().getColumn(1).setPreferredWidth(180);
        jTablePacientes.getColumnModel().getColumn(2).setPreferredWidth(110);
        jTablePacientes.getColumnModel().getColumn(3).setPreferredWidth(90);
        jTablePacientes.getColumnModel().getColumn(4).setPreferredWidth(110);
        jTablePacientes.getColumnModel().getColumn(5).setPreferredWidth(160);
        jTablePacientes.getColumnModel().getColumn(6).setPreferredWidth(110);

        // Altura das linhas
        jTablePacientes.setRowHeight(24);
    }

    private void carregarTodos() {
        listaPacientes = dao.listarTodos();
        preencherTabela(listaPacientes);
    }

    private void preencherTabela(List<Paciente> lista) {
        DefaultTableModel modelo = (DefaultTableModel) jTablePacientes.getModel();
        modelo.setRowCount(0); // limpa a tabela
        for (Paciente p : lista) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getCpf(),
                p.getDataNascimento(),
                p.getTelefone(),
                p.getEmail(),
                p.getConvenio()
            });
        }
        // Atualiza a referência
        listaPacientes = lista;
    }

    private Paciente getPacienteSelecionado() {
        int linha = jTablePacientes.getSelectedRow();
        if (linha < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um paciente na tabela!", "Atenção", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        return listaPacientes.get(linha);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelBuscar = new javax.swing.JLabel();
        jTextFieldBusca = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jButtonMostrarTodos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePacientes = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jButtonNovo = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de Pacientes");

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 16));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("LISTA DE PACIENTES");

        jLabelBuscar.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabelBuscar.setText("Buscar por nome:");

        jTextFieldBusca.setFont(new java.awt.Font("Tahoma", 0, 12));

        jButtonBuscar.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jButtonMostrarTodos.setFont(new java.awt.Font("Tahoma", 0, 12));
        jButtonMostrarTodos.setText("Mostrar Todos");
        jButtonMostrarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostrarTodosActionPerformed(evt);
            }
        });

        jTablePacientes.setFont(new java.awt.Font("Tahoma", 0, 12));
        jTablePacientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTablePacientes);

        jButtonNovo.setBackground(new java.awt.Color(40, 150, 50));
        jButtonNovo.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButtonNovo.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNovo.setText("Novo Paciente");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonEditar.setBackground(new java.awt.Color(30, 120, 180));
        jButtonEditar.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButtonEditar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEditar.setText("Editar Selecionado");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonExcluir.setBackground(new java.awt.Color(200, 60, 60));
        jButtonExcluir.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButtonExcluir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExcluir.setText("Excluir Selecionado");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonFechar.setFont(new java.awt.Font("Tahoma", 0, 12));
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
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelBuscar)
                        .addGap(5, 5, 5)
                        .addComponent(jTextFieldBusca)
                        .addGap(5, 5, 5)
                        .addComponent(jButtonBuscar)
                        .addGap(5, 5, 5)
                        .addComponent(jButtonMostrarTodos))
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonNovo)
                        .addGap(8, 8, 8)
                        .addComponent(jButtonEditar)
                        .addGap(8, 8, 8)
                        .addComponent(jButtonExcluir)
                        .addGap(8, 8, 8)
                        .addComponent(jButtonFechar)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelTitulo)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBuscar)
                    .addComponent(jTextFieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscar)
                    .addComponent(jButtonMostrarTodos))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        String termo = jTextFieldBusca.getText().trim();
        if (termo.isEmpty()) {
            carregarTodos();
        } else {
            List<Paciente> resultado = dao.buscarPorNome(termo);
            preencherTabela(resultado);
            if (resultado.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhum paciente encontrado para: " + termo,
                        "Busca", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void jButtonMostrarTodosActionPerformed(java.awt.event.ActionEvent evt) {
        jTextFieldBusca.setText("");
        carregarTodos();
    }

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {
        TelaCadastroPaciente tela = new TelaCadastroPaciente(parent, null);
        tela.setVisible(true);
        carregarTodos(); // Recarrega a lista após cadastro
    }

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {
        Paciente p = getPacienteSelecionado();
        if (p != null) {
            TelaCadastroPaciente tela = new TelaCadastroPaciente(parent, p);
            tela.setVisible(true);
            carregarTodos(); // Recarrega após edição
        }
    }

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        Paciente p = getPacienteSelecionado();
        if (p != null) {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Deseja excluir o paciente:\n" + p.getNome() + "\n\nEsta ação não pode ser desfeita!",
                    "Confirmar Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                if (dao.excluir(p.getId())) {
                    JOptionPane.showMessageDialog(this, "Paciente excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    carregarTodos();
                }
            }
        }
    }

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonMostrarTodos;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JLabel jLabelBuscar;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTablePacientes;
    private javax.swing.JTextField jTextFieldBusca;
    // End of variables declaration
}
