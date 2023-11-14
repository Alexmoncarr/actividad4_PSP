package Actividad2_5;

import java.util.ArrayList;

public class ColaSincronizada {
    private ArrayList<Integer> contenedor = new ArrayList<>();

    public synchronized void put(int value) {
        contenedor.add(value);
        System.out.println("Productor produce: " + value);
        notify(); // Notifica a los consumidores que hay datos disponibles
    }

    public synchronized int get() {
        while (contenedor.isEmpty()) {
            try {
                wait(); // Espera si no hay datos disponibles
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int value = contenedor.remove(0);
        System.out.println("Consumidor consume: " + value);
        return value;
    }
}
