import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
         testeGrafico();
        // testConexao();
    }

    public static void testeGrafico() {
        BaseGrafico baseGraficos = new BaseGrafico();
        List<String> lista = new ArrayList<>();
        // select name, value from tbltarefas;

        String[] title = { "Titulo", "'Tempo'" };
        lista.add(title[0] + "," + title[1]);
        lista.add("comprar,12");
        lista.add("trabalho,20");
        lista.add("limpar,32");
        lista.add("descancar,12");
        lista.add("cozinhar,11");
        lista.add("relaxar,5");

        int cont = 1;
        String data = "";

        for (String string : lista) {

            data += String.format("[\'%s\',%s]", string.split(",")[0], string.split(",")[1]);
            if (cont < lista.size())
                data += ",";

            cont++;
        }
        System.out.println(data);
        // ["tarefa", "tempo"], ["comprar", "45"], ["limpar", "12"], ["cozinhar", "80"]

        String volume = baseGraficos.baseHTML(TipoGrafico.BAR, "Teste", "Teste2", data);
        new CreateFile("index.html", volume);
        // System.out.println(baseGraficos.baseHTML(TipoGrafico.BAR, "Teste",
        // "Teste2",data));
    }

    public static void testConexao() {
        ConexaoBanco conexaoBanco = new ConexaoBanco();

        conexaoBanco.connectionUtil();
    }
}