package Actividad2_5;

import java.util.Random;


public class Consumidor implements Runnable {
    private ColaSincronizada cola;

    public Consumidor(ColaSincronizada cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            cola.get();

            try {
                Thread.sleep(random.nextInt(500)); // Tiempo de espera aleatorio entre 0 y 500 ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
