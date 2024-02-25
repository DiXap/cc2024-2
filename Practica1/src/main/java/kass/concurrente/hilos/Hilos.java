package kass.concurrente.hilos;

import java.util.ArrayList;
import java.util.List;

public class Hilos implements Runnable {
    
    @Override
    public void run() { //Sobrescribimos el metodo run
        int ID = Integer.parseInt(Thread.currentThread().getName());
        if(ID == 1){
            System.out.println("Soy el hilo 1");
        }else{
            System.out.println("Hola soy el: "+ Thread.currentThread().getName());//Pedimos el nombre del hilo pidiendo primero que se seleccione el Hilo
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Hilos h = new Hilos(); // Crea una instancia de la clase
        List<Thread> threadsArr = new ArrayList<>(); // Crea la lista (ds) para almacenar los hilos

        for (int i = 0; i < 10; i++) {
            Thread dummy = new Thread(h, Integer.toString(i + 1)); // Crea un hilo pasandole la instancia de la clase y el valor de i+1
            dummy.start();         // Inicializa el hilo antes de agregarlo a la ds
            threadsArr.add(dummy); // Agrega el hilo a la ds
        }

        for (Thread thread : threadsArr) {
            thread.join(); // Aplica `join()` a todos los hilos en la ds
        }
    }
}
