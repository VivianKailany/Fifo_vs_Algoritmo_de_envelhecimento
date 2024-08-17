package Algoritmos;

import java.util.HashMap;
import java.util.Map;

public class Velhinho {
    private int frames;
    private Map<Integer, Integer> paginaTabela;
    private Map<Integer, Integer> idadeTabela;

    public Velhinho(int frames) {
        this.frames = frames;
        this.paginaTabela = new HashMap<>();
        this.idadeTabela = new HashMap<>();
    }

    public int run(int[] paginaReferencia) {
        int paginaFaltando = 0;
        for (int pagina : paginaReferencia) {
            if (!paginaTabela.containsKey(pagina)) {
                if (paginaTabela.size() == frames) {
                    removePaginaVelha();
                }
                paginaTabela.put(pagina, 0);
                paginaFaltando++;
            }
            idadePagina();
            idadeTabela.put(pagina, 0);
        }
        return paginaFaltando;
    }

    private void idadePagina() {
        idadeTabela.replaceAll((k, v) -> v + 1);
    }

    private void removePaginaVelha() {
        int paginaVelha = -1;
        int idadeMaxima = -1;
        for (Map.Entry<Integer, Integer> entry : idadeTabela.entrySet()) {
            if (entry.getValue() > idadeMaxima) {
                idadeMaxima = entry.getValue();
                paginaVelha = entry.getKey();
            }
        }
        paginaTabela.remove(paginaVelha);
        idadeTabela.remove(paginaVelha);
    }
}


