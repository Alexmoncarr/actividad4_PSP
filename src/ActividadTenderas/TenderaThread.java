package ActividadTenderas;

public class TenderaThread extends Thread {
    private String nombre;

    public TenderaThread(String nombre) {
        this.nombre = nombre;
    }

    public void run() {
        Cliente cliente = new Cliente("Juan", new int[] { 2, 2, 1, 5, 2, 3 });
        long initialTime = System.currentTimeMillis();
        System.out.println("La Tendera " + this.nombre + " COMIENZA A COBRAR LA COMPRA DEL CLIENTE " +
                cliente.getNombre() +
                " EN: " + (System.currentTimeMillis() - initialTime) / 1000 +
                "seg");

        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            esperarXsegundos(cliente.getCarroCompra()[i]);
            System.out.println("Cobrando el producto " + (i + 1) +
                    " ->en: " + (System.currentTimeMillis() - initialTime) / 1000 +
                    "seg");
        }

        System.out.println("La Tendera " + this.nombre + " HA TERMINADO DE COBRAR " +
                cliente.getNombre() + " EN: " + (System.currentTimeMillis() - initialTime) / 1000 +
                "seg");
    }

    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
