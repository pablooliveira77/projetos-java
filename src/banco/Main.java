package banco;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaUsuarios listaUsuarios = new ListaUsuarios(new ArrayList<>());

        Usuario joao = new Usuario("João", "12345678900", new Conta(1, 1000.0));
        Usuario maria = new Usuario("Maria", "98765432100", new Conta(2, 500.0));

        listaUsuarios.adicionarUsuario(joao);
        listaUsuarios.adicionarUsuario(maria);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu CPF para acessar o sistema: ");
        String cpf = scanner.nextLine();

        Usuario usuarioLogado = listaUsuarios.buscarPorCpf(cpf);
        if (usuarioLogado == null) {
            System.out.println("Usuário não encontrado com o CPF: " + cpf);
            System.out.println("Encerrando o programa.");
            return;
        } else {
            System.out.println("Usuário logado: " + usuarioLogado);
        }

        int opcao = 0;
        System.out.println("Bem-vindo ao sistema bancário!");

        while (opcao != 5) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Exibir saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Buscando saldo de: " + usuarioLogado.getNome());
                    System.out.println(
                            "Saldo atual de " + usuarioLogado.getNome() + ": " + usuarioLogado.getConta().getSaldo());
                    break;
                case 2:
                    System.out.println("Digite o valor do deposito? ");
                    double valorDeposito = scanner.nextDouble();
                    usuarioLogado.getConta().depositar(valorDeposito);
                    System.out.println(
                            "Saldo atual de " + usuarioLogado.getNome() + ": " + usuarioLogado.getConta().getSaldo());
                    break;
                case 3:
                    System.out.println("Digite o valor do saque? ");
                    double valorSaque = scanner.nextDouble();
                    usuarioLogado.getConta().sacar(valorSaque);
                    System.out.println(
                            "Saldo atual de " + usuarioLogado.getNome() + ": " + usuarioLogado.getConta().getSaldo());
                    break;
                case 4:
                    System.out.print("Digite o numero da conta deseja transferir: ");
                    int numeroConta = scanner.nextInt();
                    Usuario usuarioDestino = listaUsuarios.buscarPorConta(numeroConta);
                    if (usuarioDestino == null) {
                        System.out.println("Conta não encontrada com o número: " + numeroConta);
                    } else {
                        System.out.println("Digite o valor da transferência: ");
                        double valorTransferencia = scanner.nextDouble();
                        usuarioLogado.getConta().transferir(usuarioDestino.getConta(), valorTransferencia);
                        System.out.println(
                                "Saldo atual de " + usuarioLogado.getNome() + ": "
                                        + usuarioLogado.getConta().getSaldo());
                        System.out.println(
                                "Saldo atual de " + usuarioDestino.getNome() + ": "
                                        + usuarioDestino.getConta().getSaldo());
                    }
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
        System.out.println("=========== FIM DO PROGRAMA ===========");
        System.out.println("Obrigado por usar nosso sistema bancário! Até logo.");
        System.out.println("Usuário João: " + joao);
        System.out.println("Usuário Maria: " + maria);
    }

}
