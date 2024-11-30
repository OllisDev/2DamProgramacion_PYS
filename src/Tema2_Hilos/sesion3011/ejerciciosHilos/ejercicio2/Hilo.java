package Tema2_Hilos.sesion3011.ejerciciosHilos.ejercicio2;
/*
Ejercicio 2: Crea tres hilos. Cada hilo debe contar del 10 al 1 (en orden inverso).
El primer hilo debe contar cada 300 ms, el segundo cada 700 ms, y el tercero cada 1500 ms.
Imprime el número en la consola junto con el nombre del hilo que lo generó.
 */
public class Hilo extends Thread {
    private String name;
    private int adolfmir;

    public Hilo(String name, int adolfmir) {
        this.name = name;
        this.adolfmir = adolfmir;
    }

    @Override
    public void run() {
        for (int i = 10; i >= 1; i--) {
            System.out.println("Número: " + i + " " + this.name);

            try {
                Thread.sleep(adolfmir);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Hilo hilo1 = new Hilo("Hilo 1", 300);
        Hilo hilo2 = new Hilo("Hilo 2", 700);
        Hilo hilo3 = new Hilo("Hilo 3", 1500);

        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}
