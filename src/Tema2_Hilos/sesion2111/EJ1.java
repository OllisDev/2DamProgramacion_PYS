package Tema2_Hilos.sesion2111;

/*
Ejercicio 1: Crea un programa en el que un hilo imprima "Hola desde un Hilo" en la consola cinco veces.
Usa Thread.sleep(1000) para que el hilo espere un segundo entre cada mensaje.
 */
public class EJ1 extends Thread{
    private String name; // Variable para darle un nombre a nuestros hilos

    //Constructor
    public EJ1(String name) {
        this.name = name;
    }
    public void run() {
        for (int i = 0; i <= 4; i++) {
            System.out.println("Hola desde un Hilo " + this.name + " iter " + i);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        EJ1 hilo1 = new EJ1("hilo1");
        EJ1 hilo2 = new EJ1("hilo2");
        hilo1.start();
        hilo2.start();
    }
}
