
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int[] framesArray = {3, 4, 5, 6, 7}; // Exemplo de números de molduras de páginas

        Paginas simulador = new Paginas(10); // Exemplo de intervalo de páginas

        try {
            simulador.salvarReferencias("page_references.txt");
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo de referências: " + e.getMessage());
        }

        for (int frames : framesArray) {
            simulador.simulate(frames);
        }
    }
}
