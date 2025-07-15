package financeiro;

import java.io.*;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class UtilsJson {
    private String caminho = "src/financeiro/despesas.json";

    public List<Lancamento> lerJson() {
        try {
            FileReader reader = new FileReader(caminho);

            // Tipo da lista de despesas
            Type despesaListType = new TypeToken<List<Lancamento>>() {
            }.getType();

            // Instanciando Gson
            Gson gson = new Gson();

            // Convertendo JSON para lista de objetos
            List<Lancamento> despesas = gson.fromJson(reader, despesaListType);

            reader.close();

            return despesas;

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo JSON: " + e.getMessage());
        }
        return null;
    }

    public void AtualizarJson(List<Lancamento> lancamentos) {
        try {
            FileWriter writer = new FileWriter(caminho);
            Gson gson = new Gson();
            // Convertendo objeto Lancamento para JSON
            String json = gson.toJson(lancamentos);
            // Escrevendo o JSON no arquivo
            writer.write(json);
            writer.close();

        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo JSON: " + e.getMessage());
        }
    }
}
