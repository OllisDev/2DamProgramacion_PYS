package Tema2_Hilos.sesion3011.repasoHilos.EjemploSleepJoin;

public class EjemploSleepJoin {
    public static void main(String[] args) {
        // Crear el primer hilo
        Thread hilo1 = new Thread(() -> {
            try {
                System.out.println("Hilo 1: Ejecutándose...");
                Thread.sleep(2000); // Pausa el hilo durante 2 segundos
                System.out.println("Hilo 1: Terminado.");
            } catch (InterruptedException e) {
                System.out.println("Hilo 1 interrumpido.");
            }
        });

        // Crear el segundo hilo
        Thread hilo2 = new Thread(() -> {
            System.out.println("Hilo 2: Esperando al Hilo 1...");
            try {
                hilo1.join(); // Espera a que hilo1 termine antes de continuar
                System.out.println("Hilo 2: Continuando después del Hilo 1.");
            } catch (InterruptedException e) {
                System.out.println("Hilo 2 interrumpido.");
            }
        });

        hilo1.start(); // Iniciar el primer hilo
        hilo2.start(); // Iniciar el segundo hilo
    }
}

