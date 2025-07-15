package financeiro;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Controle controle = new Controle();
        System.out.println("Bem-vindo ao sistema financeiro!");
        System.out.println("=========================================");

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("Selecione uma opção:");
            System.out.println("[1] Adicionar lançamento");
            System.out.println("[2] Listar lançamentos");
            System.out.println("[3] Ver saldo total");
            System.out.println("[4] Filtrar por categoria");
            System.out.println("[5] Filtrar por Mês");
            System.out.println("[6] Sair");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Data (YYYY-MM-DD): ");
                    String data = scanner.nextLine();
                    System.out.print("Valor: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a quebra de linha
                    System.out.print("Tipo (entrada/saida): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Categoria: ");
                    String categoria = scanner.nextLine();

                    controle.adicionarLancamentos(data, valor, tipo, descricao, categoria);
                    break;

                case 2:
                    controle.getLista();
                    break;

                case 3:
                    controle.getSaldoTotal();
                    break;

                case 4:
                    System.out.print("Categoria: ");
                    String cat = scanner.nextLine();
                    controle.getListaPorCategoria(cat);
                    break;

                case 5:
                    System.out.print("Mês (MM): ");
                    String mes = scanner.nextLine();
                    controle.getListaPorMes(mes);
                    break;

                case 6:
                    System.out.println("Saindo...");
                    controle.atualizarJson();
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
        System.out.println("Obrigado por usar o sistema financeiro!");
    }
}
