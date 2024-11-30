package Tema2_Hilos.sesion2911.problema1;

class Contador {

    private int contador = 0;

    public synchronized void incrementar() {
        contador++;
    }

    public int getContador() {
        return contador;
    }

}
public class Contador_examen extends Thread{

    private Contador contador = null;

    public Contador_examen(String hiloNombre, Contador contador){
        super(hiloNombre);
        this.contador = contador;
    }


    @Override
    public void run() {
        System.out.println (getName());
        for (int i = 0; i < 100000; i++) {
            contador.incrementar();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador();

        Contador_examen hilo1 = new Contador_examen("hilo1", contador);
        Contador_examen hilo2 = new Contador_examen("hilo2", contador);
        Contador_examen hilo3 = new Contador_examen("hilo3", contador);

        hilo1.start();
        hilo2.start();
        hilo3.start();

        hilo1.join();
        hilo2.join();
        hilo3.join();

        System.out.println("Contador final: " + contador.getContador());
    }
}
