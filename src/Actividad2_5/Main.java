package Actividad2_5;

public class Main {
    public static void main(String[] args) {
        ColaSincronizada cola = new ColaSincronizada();

        Thread productorThread = new Thread(new Productor(cola));
        Thread consumidorThread = new Thread(new Consumidor(cola));

        productorThread.start();
        consumidorThread.start();
    }
}
