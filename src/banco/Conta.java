package banco;

public class Conta {
    private int numeroConta;
    private double saldo;

    public Conta(int numeroConta, double saldo) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void sacar(double saque) {
        if (saque > this.saldo) {
            System.out.println("Saque maior que o saldo disponível.");
        } else {
            this.saldo -= saque;
            System.out.println("Saque realizado com sucesso.");
        }
    }

    public void depositar(double saldo) {
        this.saldo += saldo;
        System.out.println("Depósito realizado com sucesso.");
    }

    public void transferir(Conta contaDestino, double valor) {
        if (valor > this.saldo) {
            System.out.println("Saque maior que o saldo disponível para transferência.");
        } else {
            contaDestino.depositar(valor);
            this.saldo -= valor;
            System.out.println("Transferência realizada com sucesso.");
        }
    }

    @Override
    public String toString() {
        return "[numeroConta=" + getNumeroConta() + ", saldo=" + getSaldo() + "]";
    }
}
