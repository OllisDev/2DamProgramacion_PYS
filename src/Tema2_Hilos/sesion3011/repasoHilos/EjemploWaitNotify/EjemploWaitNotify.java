package Tema2_Hilos.sesion3011.repasoHilos.EjemploWaitNotify;

// Clase que simula un recurso compartido
class Recurso {
    private boolean disponible = false; // Indica si el recurso está disponible

    // Método sincronizado para que el consumidor espere por el recurso
    public synchronized void esperarDato() {
        while (!disponible) { // Mientras el recurso no esté disponible
            try {
                System.out.println(Thread.currentThread().getName() + " esperando...");
                wait(); // El hilo espera
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrumpido.");
            }
        }
        System.out.println(Thread.currentThread().getName() + " recibió el dato.");
        disponible = false; // Consume el recurso
    }

    // Método sincronizado para que el productor genere un recurso
    public synchronized void generarDato() {
        System.out.println(Thread.currentThread().getName() + " generando dato...");
        disponible = true; // Hace que el recurso esté disponible
        notify(); // Notifica a un hilo en espera
    }
}

public class EjemploWaitNotify {
    public static void main(String[] args) {
        Recurso recurso = new Recurso(); // Crear el recurso compartido

        // Crear un hilo consumidor
        Thread consumidor = new Thread(recurso::esperarDato, "Consumidor");

        // Crear un hilo productor
        Thread productor = new Thread(recurso::generarDato, "Productor");

        consumidor.start(); // Iniciar el consumidor (esperará primero)
        try {
            Thread.sleep(1000); // Asegurar que el consumidor inicie primero
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productor.start(); // Iniciar el productor (generará el recurso después)
    }
}

