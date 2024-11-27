package Tema2_Hilos.sesion2711.ejerciciosRepaso.ejercicio1;

/*
Ejercicio 1: Crea un programa en el que un hilo imprima "Hola desde un Hilo" en la consola cinco veces.
Usa Thread.sleep(1000) para que el hilo espere un segundo entre cada mensaje.
 */
public class Hilo extends Thread {
    private String name;

    // Constructor
    private Hilo(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i <= 4; i++) {
            System.out.println("Hola desde un hilo " + this.name + " iter " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Hilo hilo = new Hilo("El bicho");
        Hilo hilo2 = new Hilo("Enano cabrón");
        hilo.start();
        hilo2.start();
    }
}


