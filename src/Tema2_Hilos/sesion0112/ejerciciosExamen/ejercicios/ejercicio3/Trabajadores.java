package Tema2_Hilos.sesion0112.ejerciciosExamen.ejercicios.ejercicio3;

public class Trabajadores extends Thread {
    private Almacen almacen;

    public Trabajadores(Almacen almacen) {
        this.almacen = almacen;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                almacen.descargarCajas(20);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
