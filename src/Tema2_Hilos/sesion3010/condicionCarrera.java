package Tema2_Hilos.sesion3010;

// Esta clase lo que ocurre es que estamos creando un hilo mediante la interfaz de Runnable que
// mediante guardando un contador que incrementa
// su valor cada vez que lo recorremos hasta llegar a 10000.
// Se trata de una condicion de carrera (termina el que no esperas al que termine), en el que ambos hilos no se ponen de acuerdo y no coinciden en el mismo valor. Por lo que, es importante que ambos hilos se pongan de acuerdo, es decir, necesitamos ordenar cada hilo para que vayan a la misma sincronización, entonces utilizamos el metodo synchronized

import java.util.concurrent.atomic.AtomicInteger;

public class condicionCarrera implements Runnable {
   private AtomicInteger contador = new AtomicInteger(0);
    // private int contador = 0; // variable para guardar el contador

    // Metodo incrementar(): incrementar el contador mediante el incremental (syncronized como metodo)
   /*
    public synchronized void incrementar
        contador++;
    */

    /* syncronized como bloque
    public void incrementar
        synchronized (this) {
            contador++;
        }
    */

    public void incrementar(){
        contador.incrementAndGet();
    }

    @Override
    // Metodo run(): iniciar hilo recorriendolo para incrementar el valor del hilo
    public void run() {
        for (int i = 0; i < 10000; i++) {
            incrementar();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        condicionCarrera carrera = new condicionCarrera(); // Instanciar clase del Runnable
        Thread hilo1 = new Thread(carrera); // creacion del primer hilo
        Thread hilo2 = new Thread(carrera); // creacion del segundo hilo

        hilo1.start(); // metodo start(): inicia el hilo y llama al metodo run()
        hilo2.start();

        hilo1.join(); // metodo join(): espera a que el hilo termine para que comience el siguiente hilo
        hilo2.join();

        System.out.println("Valor final del contador: " + carrera.contador); // mostrar el valor final del contador.

    }
}
