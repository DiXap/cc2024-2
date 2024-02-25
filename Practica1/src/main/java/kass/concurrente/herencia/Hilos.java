package kass.concurrente.herencia;

import java.util.ArrayList;
import java.util.List;

/**
 * En esta clase, debes crear un contador extendiendo de la clase Thread
 * @author Kassandra Mirael
 * @version 1.1
 */
public class Hilos extends Thread {
    public static final Integer RONDAS = 10000;
    public static final Integer HILOS = 3;
    private Integer count;

    public Hilos() {
        this.count = 0;
    }

    public Integer getCount() {
        return this.count;
    }
    
    @Override
    public void run() {
        System.out.println("[INFO] Ejecutando hilo ...");
        for (int i = 0; i < RONDAS; i++) {
            try {
                Thread current = Thread.currentThread();
                current.sleep(2);
                this.count ++;
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Hilos h = new Hilos();
        List<Thread> threadsArr = new ArrayList<>(); // Crea la lista (ds) para almacenar los hilos

        for (int i = 0; i < HILOS; i++) {
            Thread dummy = new Thread(h, Integer.toString(i + 1)); // Crea un hilo pasandole la instancia de la clase y el valor de i+1
            dummy.start();         // Inicializa el hilo antes de agregarlo a la ds
            threadsArr.add(dummy); // Agrega el hilo a la ds
        }

        for (Thread thread : threadsArr) {
            thread.join(); // Aplica `join()` a todos los hilos en la ds
        }

        System.out.println("[INFO] Valor final del contador: " + h.getCount());
    }
}
