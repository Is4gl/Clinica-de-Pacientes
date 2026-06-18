package clinicajava;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * DAO (Data Access Object) para operações CRUD de Pacientes.
 */
public class PacienteDAO {

    // ==================== INSERIR ====================
    public boolean inserir(Paciente p) {
        String sql = "INSERT INTO pacientes (nome, cpf, data_nascimento, telefone, email, endereco, convenio, observacoes) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection con = Conexao.getConexao();
            if (con == null) return false;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setString(2, p.getCpf());
            ps.setString(3, p.getDataNascimento());
            ps.setString(4, p.getTelefone());
            ps.setString(5, p.getEmail());
            ps.setString(6, p.getEndereco());
            ps.setString(7, p.getConvenio());
            ps.setString(8, p.getObservacoes());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir paciente:\n" + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // ==================== ATUALIZAR ====================
    public boolean atualizar(Paciente p) {
        String sql = "UPDATE pacientes SET nome=?, cpf=?, data_nascimento=?, telefone=?, email=?, endereco=?, convenio=?, observacoes=? WHERE id=?";
        try {
            Connection con = Conexao.getConexao();
            if (con == null) return false;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setString(2, p.getCpf());
            ps.setString(3, p.getDataNascimento());
            ps.setString(4, p.getTelefone());
            ps.setString(5, p.getEmail());
            ps.setString(6, p.getEndereco());
            ps.setString(7, p.getConvenio());
            ps.setString(8, p.getObservacoes());
            ps.setInt(9, p.getId());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar paciente:\n" + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // ==================== EXCLUIR ====================
    public boolean excluir(int id) {
        String sql = "DELETE FROM pacientes WHERE id=?";
        try {
            Connection con = Conexao.getConexao();
            if (con == null) return false;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir paciente:\n" + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // ==================== LISTAR TODOS ====================
    public List<Paciente> listarTodos() {
        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM pacientes ORDER BY nome";
        try {
            Connection con = Conexao.getConexao();
            if (con == null) return lista;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Paciente p = new Paciente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("data_nascimento"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("endereco"),
                        rs.getString("convenio"),
                        rs.getString("observacoes")
                );
                lista.add(p);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar pacientes:\n" + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    // ==================== BUSCAR POR NOME ====================
    public List<Paciente> buscarPorNome(String nome) {
        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM pacientes WHERE nome LIKE ? ORDER BY nome";
        try {
            Connection con = Conexao.getConexao();
            if (con == null) return lista;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Paciente p = new Paciente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("data_nascimento"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("endereco"),
                        rs.getString("convenio"),
                        rs.getString("observacoes")
                );
                lista.add(p);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar paciente:\n" + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    // ==================== BUSCAR POR CPF ====================
    public Paciente buscarPorCpf(String cpf) {
        String sql = "SELECT * FROM pacientes WHERE cpf=?";
        try {
            Connection con = Conexao.getConexao();
            if (con == null) return null;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Paciente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("data_nascimento"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("endereco"),
                        rs.getString("convenio"),
                        rs.getString("observacoes")
                );
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar por CPF:\n" + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
