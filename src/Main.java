import java.io.IOException;
import java.lang.ProcessBuilder;
import java.lang.Process;

public class Main {
    public static void main(String[] args) {
        try {
            // Iniciar el Bloc de notas
            ProcessBuilder pb = new ProcessBuilder("Notepad.exe");
            Process p = pb.start();

            // Comprobar si el proceso está en ejecución
            System.out.println("El proceso está en ejecución: " + p.isAlive());

            // Esperar 20 segundos
            Thread.sleep(20000);

            // Comprobar de nuevo si el proceso está en ejecución
            System.out.println("El proceso está en ejecución: " + p.isAlive());

            // Cerrar el proceso
            p.destroy();

            // Comprobar si el proceso se ha cerrado
            System.out.println("El proceso está en ejecución: " + p.isAlive());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
