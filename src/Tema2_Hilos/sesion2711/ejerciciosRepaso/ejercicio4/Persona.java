package Tema2_Hilos.sesion2711.ejerciciosRepaso.ejercicio4;

public class Persona implements Runnable {
    String name;
    Banco banco = null;

    public Persona(String name, Banco banco) {
        this.name = name;
        this.banco = banco;
    }

    @Override
    public void run() {
        banco.depositar(200);
        banco.retirar(400);
    }


}
