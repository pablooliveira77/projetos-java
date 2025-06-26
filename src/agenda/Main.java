package agenda;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        System.out.println("Lista de contatos:");
        agenda.listarContatos();

        System.out.println("====================");

        Contato contato1 = new Contato("Alice", "1234-5678");
        Contato contato2 = new Contato("Bob", "8765-4321");
        Contato contato3 = new Contato("Charlie", "5555-5555");
        Contato contato4 = new Contato("Diana", "9999-9999");
        Contato contato5 = new Contato("Eve", "1111-1111");

        agenda.adicionarContato(contato1);
        agenda.adicionarContato(contato2);
        agenda.adicionarContato(contato3);
        agenda.adicionarContato(contato4);
        agenda.adicionarContato(contato5);

        System.out.println("Lista de contatos:");
        agenda.listarContatos();
    }
}
