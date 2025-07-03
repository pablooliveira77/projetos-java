package tarefas;

import java.io.*;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class UtilsJson {
    private String caminho = "src/tarefas/tarefas.json";

    public List<Tarefa> lerJson() {
        try {
            FileReader reader = new FileReader(caminho);

            // Tipo da lista de tarefas
            Type tarefaListType = new TypeToken<List<Tarefa>>() {
            }.getType();

            // Instanciando Gson
            Gson gson = new Gson();

            // Convertendo JSON para lista de objetos
            List<Tarefa> tarefas = gson.fromJson(reader, tarefaListType);

            reader.close();

            return tarefas;

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo JSON: " + e.getMessage());
        }
        return null;
    }

    public void AtualizarJson(List<Tarefa> tarefas) {
        try {
            FileWriter writer = new FileWriter(caminho);
            Gson gson = new Gson();
            // Convertendo objeto Tarefa para JSON
            String json = gson.toJson(tarefas);
            // Escrevendo o JSON no arquivo
            writer.write(json);
            writer.close();

        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo JSON: " + e.getMessage());
        }
    }
}
