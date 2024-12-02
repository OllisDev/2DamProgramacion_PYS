package Tema2_Hilos.sesion0112.ejerciciosExamen.ejercicios.ejercicio1;

public class Banco extends Thread {
    private Cajero cajero;
    private String name;
    private Cajero cajeroBanco;

    public Banco(String name, Cajero cajeroBanco) {
        this.name = name;
        this.cajeroBanco = cajeroBanco;
    }

    @Override
    public void run() {
        cajeroBanco.reponerDinero(1000);
    }

}
