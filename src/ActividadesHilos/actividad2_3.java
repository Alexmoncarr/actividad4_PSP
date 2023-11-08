package ActividadesHilos;

class ContadorVocal implements Runnable {
    private String texto;
    private char vocal;
    private int contadorLocal;
    private static int CuentaTotalDeVocales = 0;

    public ContadorVocal(String texto, char vocal) {
        this.texto = texto;
        this.vocal = vocal;
        this.contadorLocal = 0;
    }

    @Override
    public void run() {
        for (char c : texto.toCharArray()) {
            if (c == vocal) {
                contadorLocal++;
                CuentaTotalDeVocales++;
            }
        }
        System.out.println("Hilo para vocal " + vocal + " encontró " + contadorLocal + " vocales.");
    }

    public static int getCuentaTotalDeVocales() {
        return CuentaTotalDeVocales;
    }
}

public class actividad2_3 {
    public static void main(String[] args) {
        String texto = "Este es un ejemplo de texto para contar vocales.";
        Thread[] threads = new Thread[5];
        char[] vocales = {'a', 'e', 'i', 'o', 'u'};

        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new ContadorVocal(texto, vocales[i]));
            threads[i].start();
        }

        // Esperar a que todos los hilos terminen
        for (int i = 0; i < 5; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("El número total de vocales es: " + ContadorVocal.getCuentaTotalDeVocales());
    }
}
