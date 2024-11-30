package Tema2_Hilos.sesion3011.ejerciciosHilos.ejercicio1;

/*
Ejercicio 1: Crea un programa que use un hilo para imprimir los números del 1 al 5.
Usa Thread.sleep(1500) para que el hilo espere 1.5 segundos entre cada número.
Al final, el hilo debe imprimir "Hilo terminado".
 */
public class Hilo extends Thread {
    private String name;

    public Hilo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println("Numero: " + i + " " + this.name);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("El hilo ha terminado");
    }

    public static void main(String[] args) {
        Hilo hilo1 = new Hilo("El bicho");
        hilo1.start();
    }
}
