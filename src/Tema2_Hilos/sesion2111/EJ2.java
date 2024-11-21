package Tema2_Hilos.sesion2111;
/*
Ejercicio 2: Crea tres hilos que cuenten hasta diez y muestren el número en la consola.
Cada hilo debe contar a una velocidad distinta, por ejemplo, uno cada medio segundo, otro cada segundo, y otro cada dos segundos.
 */
public class EJ2 extends Thread{
    private String name;
    // Constructor
    public EJ2(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("Numero: " + i + " " + this.name);
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
        EJ2 hilo1 = new EJ2("hilo1");
        EJ2 hilo2 = new EJ2("hilo2");
        EJ2 hilo3 = new EJ2("hilo3");
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}
