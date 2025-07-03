package tarefas;

import java.util.List;

public class Gerenciador {
    UtilsJson utils = new UtilsJson();
    private List<Tarefa> tarefas = utils.lerJson();;

    public List<Tarefa> criarTarefa(String titulo, String descricao) {
        System.out.println("Criando nova tarefa...");

        int ultimoId = tarefas != null && !tarefas.isEmpty() ? tarefas.get(tarefas.size() - 1).getId() : 0;
        System.out.println("Último ID encontrado: " + ultimoId);
        Tarefa novaTarefa = new Tarefa(ultimoId + 1, titulo, descricao);

        System.out.println("Nova tarefa criada: " + novaTarefa);
        tarefas.add(novaTarefa);

        return tarefas;
    }

    public List<Tarefa> listarTarefasPendentes() {
        System.out.println("Listando tarefas...");

        if (tarefas == null || tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
            return tarefas;
        }
        tarefas.stream()
                .filter(tarefa -> !tarefa.getConcluida())
                .forEach(System.out::println);

        return tarefas;
    }

    public List<Tarefa> listarTodasTarefas() {
        System.out.println("Listando tarefas...");

        if (tarefas == null || tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
            return tarefas;
        }
        tarefas.stream()
                .forEach(System.out::println);

        return tarefas;
    }

    public void concluirTarefa(int idTarefa) {
        System.out.println("Concluindo tarefa com ID: " + idTarefa);

        tarefas.stream()
                .filter(t -> t.getId() == idTarefa)
                .findFirst()
                .ifPresentOrElse(
                        t -> {
                            t.setConcluida(true);
                            System.out.println("Tarefa concluída: " + t);
                        },
                        () -> System.out.println("Tarefa com ID " + idTarefa + " não encontrada."));

    }

    public void removerTarefa(int idTarefa) {
        System.out.println("Removendo tarefa com ID: " + idTarefa);

        boolean removed = tarefas.removeIf(t -> t.getId() == idTarefa);

        if (removed) {
            System.out.println("Tarefa com ID " + idTarefa + " removida com sucesso.");
        } else {
            System.out.println("Tarefa com ID " + idTarefa + " não encontrada.");
        }
    }

    public void atualizarJson() {
        System.out.println("Atualizando arquivo JSON...");
        utils.AtualizarJson(tarefas);
        System.out.println("Arquivo JSON atualizado com sucesso.");
    }
}
