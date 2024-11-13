package Tema2_Hilos.sesion1311;

import java.util.concurrent.Semaphore;

public class ejemploSemaforo {
    private static final Semaphore semaforo = new Semaphore(2); // permite máximo 3 hilos

    static class Tarea implements Runnable {
        private final String nombre;

        public Tarea(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public void run() {
            try {
                System.out.println(nombre + " está esperando...");
                semaforo.acquire(); // permite pasar a uno o a otro
                System.out.println(nombre + " accedió al recurso");
                Thread.sleep((long) Math.random() * 1000); // Simula el uso del recurso
        } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(nombre + " liberó el recurso");
                semaforo.release();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            new Thread(new Tarea("Hilo " + i)).start();
        }
    }
}
