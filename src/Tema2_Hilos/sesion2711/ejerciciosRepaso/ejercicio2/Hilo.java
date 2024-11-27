package Tema2_Hilos.sesion2711.ejerciciosRepaso.ejercicio2;
/*
Ejercicio 2: Crea tres hilos que cuenten hasta diez y muestren el número en la consola.
Cada hilo debe contar a una velocidad distinta, por ejemplo, uno cada medio segundo, otro cada segundo, y otro cada dos segundos.
 */
public class Hilo extends Thread {
    private String name;

    // Constructor
    private Hilo(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i <= 9; i++) {
            System.out.println("Nº: " + i + " " + this.name + " iter: " + i );
        }
        try {
            Thread.sleep(500);
            Thread.sleep(1000);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Hilo hilo1 = new Hilo("El bicho");
        Hilo hilo2 = new Hilo("Enano cabrón");
        Hilo hilo3 = new Hilo("Expresso de Gales");

        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}
