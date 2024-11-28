package Tema2_Hilos.sesion2711.ejerciciosRepaso.ejercicio5;

public class Productor {
    private int numTomates = 100;

    // Constructor
    public Productor(int numTomates) {
        this.numTomates = numTomates;
    }

    public void producir(int tomatesProducidos) {
        System.out.println(Thread.currentThread().getName() + " está produciendo " + this.numTomates + " tomates");
        this.numTomates += tomatesProducidos;
        System.out.println("Número de tomates: " + this.numTomates + " tomates");
    }
}
