import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        testeGrafico();
    }

    public static void testeGrafico() {
        BaseGrafico baseGraficos = new BaseGrafico();
        String data = "tarefa, tempo, comprar,1,limpar,30,cozinhar,40";
        List<String> lista = new ArrayList<>();
        lista.add("tarefa");
        lista.add("tempo");
        lista.add("comprar");
        lista.add("1");
        lista.add("limpar");
        lista.add("4");
        lista.add("cozinhar");
        lista.add("3");

        for (String string : lista) {
            System.out.println("["+string+"],");
        }

        //System.out.println(baseGraficos.baseHTML(TipoGrafico.BAR, "Teste", "Teste2", data));
    }
}