package Algoritmos;

import java.util.LinkedList;
import java.util.Queue;

public class Fifo{
    private int frames;
    private Queue<Integer> paginaQueue;

    public Fifo(int frames) {
        this.frames = frames;
        this.paginaQueue = new LinkedList<>();
    }

    public int run(int[] pageReferences) {
        int paginaFaltando = 0;
        for (int page : pageReferences) {
            if (!paginaQueue.contains(page)) {
                if (paginaQueue.size() == frames) {
                    paginaQueue.poll();
                }
                paginaQueue.add(page);
                paginaFaltando++;
            }
        }
        return paginaFaltando;
    }
}

