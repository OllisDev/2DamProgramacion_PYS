package Tema2_Hilos.sesion0112.ejerciciosExamen.ejercicios.ejercicio3;

public class Transportista extends Thread{
    private Almacen almacen;

    public Transportista(Almacen almacen) {
        this.almacen = almacen;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                almacen.recogerCajas(20);
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
