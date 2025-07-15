import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Nesse sistema contém vários projetos simples feitos em java que são feitos simplesmente para estudo e portifólio!");
        
        List<String> listaOrdenada = new ArrayList<>();
        listaOrdenada.add("Agenda");
        listaOrdenada.add("Gerenciador de Tarefas");
        listaOrdenada.add("Banco");
        listaOrdenada.add("Controle Financeiro");

        for (int i = 0; i < listaOrdenada.size(); i++) {
            System.out.println((i + 1) + ". " + listaOrdenada.get(i));
        }
    }
}
