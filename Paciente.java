package clinicajava;

/**
 * Classe modelo que representa um Paciente no sistema.
 */
public class Paciente {

    private int id;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String telefone;
    private String email;
    private String endereco;
    private String convenio;
    private String observacoes;

    // Construtor vazio
    public Paciente() {
    }

    // Construtor completo
    public Paciente(int id, String nome, String cpf, String dataNascimento,
            String telefone, String email, String endereco,
            String convenio, String observacoes) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.convenio = convenio;
        this.observacoes = observacoes;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getConvenio() { return convenio; }
    public void setConvenio(String convenio) { this.convenio = convenio; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    @Override
    public String toString() {
        return nome;
    }
}
