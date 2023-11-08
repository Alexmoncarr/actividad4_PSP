package ActividadTenderas;

public class MainThread {
    public static void main(String[] args) {
        TenderaThread tenderaThread1 = new TenderaThread("Charo");
        TenderaThread tenderaThread2 = new TenderaThread("Patricia");

        tenderaThread1.start();
        tenderaThread2.start();
    }
}
