package financeiro;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class Controle {
    UtilsJson utils = new UtilsJson();
    private List<Lancamento> lista = utils.lerJson();

    public List<Lancamento> adicionarLancamentos(String data, double valor, String tipo, String descricao,
            String categoria) {
        int proximoId = gerarProximoId();

        Lancamento lancamento = new Lancamento(proximoId, data, valor, tipo, descricao, categoria);
        if (lista == null) {
            System.out.println("Lista de lançamentos está vazia, inicializando...");
            return null;
        }
        lista.add(lancamento);
        System.out.println("Lançamento adicionado com sucesso: " + lancamento);

        return lista;
    }

    private int gerarProximoId() {
        if (lista == null || lista.isEmpty()) {
            return 1; // Primeiro ID
        }

        // Encontra o maior ID existente na lista para garantir unicidade
        int maiorId = lista.stream()
                .mapToInt(Lancamento::getId)
                .max()
                .orElse(0);

        return maiorId + 1;
    }

    public List<Lancamento> getLista() {
        if (lista == null || lista.isEmpty()) {
            System.out.println("Nenhum lançamento encontrado.");
            return lista;
        }

        lista.stream().sorted(Comparator.comparing(Lancamento::getData))
                .forEach(System.out::println);

        return lista;
    }

    public List<Lancamento> getListaReceita() {
        if (lista == null || lista.isEmpty()) {
            System.out.println("Nenhum lançamento encontrado.");
            return lista;
        }

        lista.stream().sorted(Comparator.comparing(Lancamento::getData))
                .filter(lancamento -> lancamento.getTipo().equals("entrada"))
                .forEach(System.out::println);

        if (lista.stream().noneMatch(lancamento -> lancamento.getTipo().equals("entrada"))) {
            System.out.println("Nenhuma receita encontrada.");
            return null;
        }

        return lista;
    }

    public List<Lancamento> getListaDespesa() {
        if (lista == null || lista.isEmpty()) {
            System.out.println("Nenhum lançamento encontrado.");
            return lista;
        }

        lista.stream().sorted(Comparator.comparing(Lancamento::getData))
                .filter(lancamento -> lancamento.getTipo().equals("saida"))
                .forEach(System.out::println);

        if (lista.stream().noneMatch(lancamento -> lancamento.getTipo().equals("saida"))) {
            System.out.println("Nenhuma despesa encontrada.");
            return null;
        }

        return lista;
    }

    public List<Lancamento> getListaPorCategoria(String cat) {
        if (lista == null || lista.isEmpty()) {
            System.out.println("Nenhum lançamento encontrado.");
            return lista;
        }

        lista.stream().sorted(Comparator.comparing(Lancamento::getData))
                .filter(lancamento -> lancamento.getCategoria().toLowerCase().contains(cat.toLowerCase()))
                .forEach(System.out::println);
        
        if (lista.stream().noneMatch(lancamento -> lancamento.getCategoria().toLowerCase().contains(cat.toLowerCase()))) {
            System.out.println("Nenhum lançamento encontrado para a categoria: " + cat);
            return null;
        }

        return lista;
    }

    public List<Lancamento> getListaPorMes(String mes) {
        if (lista == null || lista.isEmpty()) {
            System.out.println("Nenhum lançamento encontrado.");
            return lista;
        }

        lista.stream().sorted(Comparator.comparing(Lancamento::getData))
                .filter(lancamento -> LocalDate.parse(lancamento.getData()).getMonthValue() == Integer.parseInt(mes))
                .forEach(System.out::println);
        
        if (lista.stream().noneMatch(lancamento -> LocalDate.parse(lancamento.getData()).getMonthValue() == Integer.parseInt(mes))) {
            System.out.println("Nenhum lançamento encontrado para o mês " + mes);
            return null;
        }

        return lista;
    }

    public double getSaldoTotal() {
        if (lista == null || lista.isEmpty()) {
            System.out.println("Nenhum lançamento encontrado.");
            return 0.0;
        }

        double total = lista.stream()
                .mapToDouble(lancamento -> lancamento.getTipo().equals("entrada") ? lancamento.getValor()
                        : -lancamento.getValor())
                .sum();

        System.out.printf("Saldo total: R$%.2f%n", total);
        return total;
    }

    public void atualizarJson() {
        utils.AtualizarJson(lista);
        System.out.println("Arquivo JSON atualizado com sucesso.");
    }
}
