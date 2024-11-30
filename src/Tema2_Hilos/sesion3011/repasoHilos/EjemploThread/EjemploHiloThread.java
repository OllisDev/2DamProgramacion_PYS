package Tema2_Hilos.sesion3011.repasoHilos.EjemploThread;

// Crear una clase que extiende Thread
class MiHilo extends Thread {
    @Override
    public void run() {
        // El código dentro de run() es lo que ejecutará el hilo
        System.out.println("Hilo ejecutándose: " + Thread.currentThread().getName());
    }
}

public class EjemploHiloThread {
    public static void main(String[] args) {
        MiHilo hilo1 = new MiHilo(); // Crear un hilo mediante la clase que extiende Thread
        hilo1.start(); // Iniciar el hilo (esto llama al método run())
        MiHilo hilo2 = new MiHilo();
        hilo2.start();
    }
}
