package Tema2_Hilos.sesion3011.repasoHilos.EjemploSyncronized;

// Clase que contiene un contador como recurso compartido
class Contador {
    private int contador = 0; // Variable compartida entre los hilos

    // Método sincronizado para incrementar el contador
    public synchronized void incrementar() {
        contador++;
        System.out.println(Thread.currentThread().getName() + " incrementó: " + contador);
    }

    public int getContador() {
        return contador;
    }
}

public class EjemploSincronizado {
    public static void main(String[] args) {
        Contador contador = new Contador(); // Crear un recurso compartido

        // Crear varios hilos que acceden al mismo recurso
        Thread hilo1 = new Thread(contador::incrementar, "Hilo 1");
        Thread hilo2 = new Thread(contador::incrementar, "Hilo 2");
        Thread hilo3 = new Thread(contador::incrementar, "Hilo 3");

        // Iniciar los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}

