package Tema2_Hilos.sesion0112.ejerciciosExamen.ejercicios.ejercicio3;

/*
Ejercicio 3: Una empresa maneja un almacén donde los trabajadores (productores) descargan cajas y los transportistas (consumidores) las recogen para su distribución.
Implementa un sistema en el que el almacén tiene una capacidad limitada y el flujo de cajas debe gestionarse de manera que los trabajadores esperen si el almacén está lleno y los transportistas esperen si está vacío.
Simula el llenado y vaciado del almacén con un buffer compartido.
 */

public class Almacen {
    private int capacidadLimite;
    private int cajas;

    public Almacen(int capacidadLimite) {
        this.capacidadLimite = capacidadLimite;
        this.cajas = 0;
    }

    public synchronized void descargarCajas(int numCajas) throws InterruptedException {
        while (cajas + numCajas < capacidadLimite) {
            System.out.println("El almacen está lleno y no puedes descargar más cajas. Espera a que se vacíe.");
            wait();
        }
        System.out.println("Descargando cajas...");
        cajas += numCajas;
        System.out.println("Número de cajas: " + this.cajas + "/" + this.capacidadLimite);
        notifyAll();
    }

    public synchronized void recogerCajas(int numCajas) throws InterruptedException {
        while (cajas < numCajas) {
            System.out.println("El almacen está vacío y todavía no puedes recoger cajas. Espera a que se llene.");
            wait();
        }
        System.out.println("Recogiendo cajas...");
        cajas -= numCajas;
        System.out.println("Número de cajas: " + this.cajas + "/" + this.capacidadLimite);
        notifyAll();
    }

    public static void main(String[] args) {
        Almacen almacen = new Almacen(100);

        Trabajadores trabajadores = new Trabajadores(almacen);
        Transportista transportista = new Transportista(almacen);

        trabajadores.start();
        transportista.start();

        try {
            trabajadores.join();
            transportista.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
