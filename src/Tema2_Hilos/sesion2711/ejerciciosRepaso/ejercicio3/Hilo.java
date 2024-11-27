package Tema2_Hilos.sesion2711.ejerciciosRepaso.ejercicio3;

import java.util.Random;

/*
Ejercicio 3: Simula una carrera de tres hilos que avanzan en pasos aleatorios.
Cada hilo representa un corredor y debe imprimir su progreso en cada paso.
El primer hilo en llegar a 50 pasos (o alguna meta definida) "gana".
 */
public class Hilo implements Runnable {
    private Thread hilo = null;
    private int pasos;
    public final static int META = 50;

    public Hilo(String name) {
        this.hilo = new Thread(this, name);
    }
    @Override
    public void run() {
        Random random = new Random();
        while (pasos < META) {
            int avanzar = random.nextInt(10);
            pasos += avanzar;
            mostrarProgreso();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void mostrarProgreso() {
        StringBuilder pistaCarrera = new StringBuilder();
        for (int i = 0; i < META; i++) {
            if (i == pasos) {
               pistaCarrera.append(this.hilo.getName());
            } else {
                pistaCarrera.append("-");
            }
        }
        System.out.println(pistaCarrera.toString());
    }

    public void EjecutarHilo() {
        this.hilo.start();
    }

    public static void main(String[] args) {
        Hilo hilo1 = new Hilo("El bicho");
        Hilo hilo2 = new Hilo("Enano cabrón");
        Hilo hilo3 = new Hilo("Expresso de Gales");
        hilo1.EjecutarHilo();
        hilo2.EjecutarHilo();
        hilo3.EjecutarHilo();
    }
}
