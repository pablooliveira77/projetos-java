package banco;


public class Main {
    public static void main(String[] args) {
        Usuario joao = new Usuario("João", "123.456.789-00", new Conta(1, 1000.0));
        Usuario maria = new Usuario("Maria", "987.654.321-00", new Conta(2, 500.0));

        System.out.println("Saldo de João: " + joao.getConta().getSaldo());
        System.out.println("Saldo de Maria: " + maria.getConta().getSaldo());

        joao.getConta().depositar(200.0);
        System.out.println("Saldo de João após depósito: " + joao.getConta().getSaldo());

        maria.getConta().sacar(200.0);
        System.out.println("Saldo de Maria após saque: " + maria.getConta().getSaldo());

        joao.getConta().transferir(maria.getConta(), 500.0);
        System.out.println("Saldo de João após transferência: " + joao.getConta().getSaldo());
        System.out.println("Saldo de Maria após transferência: " + maria.getConta().getSaldo());

        System.out.println("======================");
        System.out.println(joao);
        System.out.println(maria);
    }


}
