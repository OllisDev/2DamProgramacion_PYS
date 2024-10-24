package Tema2_Hilos.sesion2410;

public class hilo implements Runnable {

    public void run() {
        try {
            Thread.sleep(1000);
            synchronized (this) {
                wait(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Thread h1 = new Thread(new hilo());
            h1.start();
            System.out.println("estado después del start: " + h1.getState());
            Thread.sleep(500);
            System.out.println("estado durante del sleep: " + h1.getState());
            Thread.sleep(1000);
            System.out.println("estado durante el wait: " + h1.getState());
            h1.join(); // espera el hilo hasta que termine
            System.out.println("estado fin: " + h1.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
