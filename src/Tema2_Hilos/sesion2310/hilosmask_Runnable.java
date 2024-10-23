package Tema2_Hilos.sesion2310;


public class hilosmask_Runnable implements Runnable {
    private Thread hilo = null;

    public hilosmask_Runnable(String name) {
        this.hilo = new Thread(this, name);
    }
    public void run() {
        for(int i = 0; i <= 30; i++) {
            System.out.println(this.hilo.getName() + " el contador " + i);
        }
    }

    public void ejecutarHilo() {
        this.hilo.start();
    }
}
