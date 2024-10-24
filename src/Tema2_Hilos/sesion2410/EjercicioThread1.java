package Tema2_Hilos.sesion2410;

public class EjercicioThread1 extends Thread{

    public void run() {
        for(int i = 0; i <= 5; i++) {
            System.out.println("Nº" + i + "Este es el hilo " + this.getName());
        }
        try {
            sleep((long) Math.random() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }

}
