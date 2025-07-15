package financeiro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Lancamento {
    private int id;
    private String data;
    private double valor;
    private String tipo; // "entrada" ou "saida"
    private String descricao;
    private String categoria;

    public Lancamento(int id, String data, double valor, String tipo, String descricao, String categoria) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.tipo = tipo;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    private String getDataFormatada() {
        LocalDate localDate = LocalDate.parse(data);
        return localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public double getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "[id=" + getId() + ", data=" + getDataFormatada() + ", valor= R$" + getValor() + ", tipo=" + getTipo() + ", descricao="
                + getDescricao() + ", categoria=" + getCategoria() + "]";
    }

}
