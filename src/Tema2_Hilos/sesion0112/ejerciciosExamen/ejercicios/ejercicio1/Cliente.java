package Tema2_Hilos.sesion0112.ejerciciosExamen.ejercicios.ejercicio1;

public class Cliente extends Thread {
    private String name;
    private int dinero;
    private Cajero cajeroCliente;

    public Cliente(String name, int dinero, Cajero cajeroCliente) {
        this.name = name;
        this.dinero = dinero;
        this.cajeroCliente = cajeroCliente;
    }

    @Override
    public void run() {
        cajeroCliente.retirarDinero(1000);
    }


}
