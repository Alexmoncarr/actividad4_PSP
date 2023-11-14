package Actividad2_5;

import java.util.Random;


public class Productor implements Runnable {
    private ColaSincronizada cola;

    public Productor(ColaSincronizada cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            cola.put(i);

            try {
                Thread.sleep(random.nextInt(1000)); // Tiempo de espera aleatorio entre 0 y 1000 ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
