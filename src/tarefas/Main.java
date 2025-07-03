package tarefas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gerenciador gerenciador = new Gerenciador();

        System.out.println("Bem-vindo ao Gerenciador de Tarefas!");
        gerenciador.listarTarefasPendentes();

        String menu = """
                Escolha uma opção:
                [1] Criar nova tarefa
                [2] Listar tarefas
                [3] Concluir tarefa
                [4] Excluir tarefa
                [5] Sair
                """;
        int opcao = 0;

        while (opcao != 5) {
            System.out.print(menu);
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.println("Digite o Título da tarefa:");
                    String titulo = scanner.nextLine();
                    System.out.println("Digite a Descrição da tarefa:");
                    String descricao = scanner.nextLine();
                    if (titulo.isEmpty() || descricao.isEmpty()) {
                        System.out.println("Título e descrição não podem ser vazios. Tarefa não criada.");
                        break;
                    }
                    gerenciador.criarTarefa(titulo, descricao);
                    break;
                case 2:
                    gerenciador.listarTarefasPendentes();
                    break;
                case 3:
                    System.out.print("Digite o ID da tarefa: ");
                    int idTarefa = scanner.nextInt();
                    gerenciador.concluirTarefa(idTarefa);
                    break;
                case 4:
                    System.out.print("Digite o ID da tarefa: ");
                    int idExcluir = scanner.nextInt();
                    gerenciador.removerTarefa(idExcluir);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        }
        // Atualizar o JSON após cada operação
        gerenciador.atualizarJson();
        scanner.close();
        System.out.println("Obrigado por usar o Gerenciador de Tarefas!");
    }
}
