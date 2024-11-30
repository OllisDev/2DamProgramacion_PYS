package Tema2_Hilos.sesion3011.ejerciciosHilos.ejercicio3;
/*
Ejercicio 3:  Simula una carrera entre tres hilos.
Cada hilo representa un corredor con un objetivo de pasos diferente:
 - Corredor 1: Debe alcanzar 40 pasos.
 - Corredor 2: Debe alcanzar 50 pasos.
 - Corredor 3: Debe alcanzar 60 pasos.
 Los hilos avanzan en pasos aleatorios entre 1 y 3.
Imprime el progreso de cada corredor y anuncia cuál llega primero a su meta.
 */

import java.util.Random;

public class carreraHilos implements Runnable {
    private int pasos;
    private int pasosCorredor;
    private String name;
    private Thread hilo;
    private static boolean metaAlcanzada = false;

    public carreraHilos(int pasosCorredor, String name) {
        this.pasosCorredor = pasosCorredor;
        this.hilo = new Thread(this, name);
        this.name = name;

    }

    @Override
    public void run() {
        Random pasosRandom = new Random();
        while (pasos < pasosCorredor && !metaAlcanzada) {
            int avanzar = pasosRandom.nextInt(3) + 1;
            pasos += avanzar;
            mostrarProgreso();
            try  {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            meta();
        }
    }

    private void mostrarProgreso() {
        StringBuilder pistaCarrera = new StringBuilder();
        for (int i = 0; i < pasosCorredor; i++) {
            if (i == pasos) {
                pistaCarrera.append("=");
            } else {
                pistaCarrera.append("-");
            }
        }
        System.out.println(pistaCarrera.toString() + this.name);
    }

    private void meta() {
        if(pasos >= pasosCorredor && !metaAlcanzada) {
            metaAlcanzada = true;
            System.out.println("El ganador es: " + this.name);
        }
    }

    private void EjecutarHilo() {
        this.hilo.start();
    }

    public static void main(String[] args) {
        carreraHilos corredor1 = new carreraHilos(40, "Vinicius");
        carreraHilos corredor2 = new carreraHilos(50, "Mbappé");
        carreraHilos corredor3 = new carreraHilos(60, "Haaland");

        corredor1.EjecutarHilo();
        corredor2.EjecutarHilo();
        corredor3.EjecutarHilo();
    }
}
