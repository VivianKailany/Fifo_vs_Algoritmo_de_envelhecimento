import Algoritmos.Fifo;
import Algoritmos.Velhinho;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Paginas {
    private static final int REFERENCIAS = 1000;
    private int[] paginaReferencias;

    public Paginas(int paginaAleatoria) {
        this.paginaReferencias = new int[REFERENCIAS];
        gerarReferencias(paginaAleatoria);
    }

    private void gerarReferencias(int paginaAleatoria) {
        Random random = new Random();
        for (int i = 0; i < REFERENCIAS; i++) {
            paginaReferencias[i] = random.nextInt(paginaAleatoria);
        }
    }

    public void salvarReferencias(String fileName) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int page : paginaReferencias) {
                writer.write(page + "\n");
            }
        }
    }

    public void simulate(int frames) {
        Fifo fifo = new Fifo(frames);
        Velhinho velhinho = new Velhinho(frames);

        int fifoFaltas = fifo.run(paginaReferencias);
        int velhinhoFaltas = velhinho.run(paginaReferencias);

        System.out.println("Frames: " + frames);
        System.out.println("FIFO Page Faults: " + fifoFaltas);
        System.out.println("Aging Page Faults: " + velhinhoFaltas);
        System.out.println();
    }
}
