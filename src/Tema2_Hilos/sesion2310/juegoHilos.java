package Tema2_Hilos.sesion2310;

import java.util.Random;

public class juegoHilos extends Thread {
    public static final int META = 100;
    private int posicion;
    private String name = "";

    public juegoHilos(String name) {
        this.name = name;
    }
    public void run() {
        Random random = new Random();
        while (posicion < META) {
            int avance = random.nextInt(10);
            posicion += avance;
            mostrarPosicion();
            try {
                Thread.sleep(random.nextInt(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void mostrarPosicion() {
        StringBuilder hipodromo = new StringBuilder();
        for (int i = 0; i < META; i++) {
            if (i == posicion) {
                hipodromo.append(this.name);
            } else {
                hipodromo.append("-");
            }
        }
        System.out.println(hipodromo.toString());
    }

    public static void main(String[] args) {
        juegoHilos caballo1 = new juegoHilos("C1");
        juegoHilos caballo2 = new juegoHilos("C2");
        caballo1.start();
        caballo2.start();
    }
}
