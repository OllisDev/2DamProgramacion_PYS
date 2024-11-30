package Tema2_Hilos.sesion3011.repasoHilos.EjemploRunnable;

// Crear una clase que implemente Runnable
class MiRunnable implements Runnable {
    @Override
    public void run() {
        // Código que ejecutará el hilo
        System.out.println("Hilo ejecutándose: " + Thread.currentThread().getName());
    }
}

public class EjemploHiloRunnable {
    public static void main(String[] args) {
        // Crear un hilo pasándole una instancia de la clase que implementa Runnable
        Thread hilo1 = new Thread(new MiRunnable());
        hilo1.start(); // Iniciar el hilo
    }
}
