package banco;

public class Usuario {
    private String nome;
    private String cpf;
    private Conta conta;

    public Usuario(String nome, String cpf, Conta conta) {
        this.nome = nome;
        this.cpf = cpf;
        this.conta = conta;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Conta getConta() {
        return conta;
    }

    @Override
    public String toString() {
        return "[nome=" + nome + ", cpf=" + cpf + ", conta=" + conta + "]";
    }
}
