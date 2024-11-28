package Tema2_Hilos.sesion2711.ejerciciosRepaso.ejercicio5;

public class Consumidor {
    private int numTomates;

    public Consumidor(int numTomates) {
        this.numTomates = numTomates;
    }

    public void consumir(int tomatesConsumidos) {
        if (tomatesConsumidos < this.numTomates) {
            System.out.println(Thread.currentThread().getName() + " está consumiendo " + this.numTomates + " tomates");
            this.numTomates -= tomatesConsumidos;
            System.out.println("Numero de tomates: " + this.numTomates + " tomates");
        }

    }
}
