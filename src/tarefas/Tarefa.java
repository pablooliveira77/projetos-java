package tarefas;

import java.time.LocalDate;

public class Tarefa {
    private int id;
    private String titulo;
    private String descricao;
    boolean concluida;
    private String dataCriacao;

    public Tarefa() {}

    public Tarefa(int id, String titulo, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluida = false;
        this.dataCriacao = getDataCriacao();
    }

    public int getId() {
        return id;
    }

    // public String getTitulo() {
    //     return titulo;
    // }

    // public void setTitulo(String titulo) {
    //     this.titulo = titulo;
    // }

    // public String getDescricao() {
    //     return descricao;
    // }

    // public void setDescricao(String descricao) {
    //     this.descricao = descricao;
    // }

    public boolean getConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public String getDataCriacao() {
        return LocalDate.now().toString();   
    }

    @Override
    public String toString() {
        return "Tarefa [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", concluida=" + concluida
                + ", dataCriacao=" + dataCriacao + "]";
    }

}
