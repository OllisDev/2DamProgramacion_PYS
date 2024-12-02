package Tema2_Hilos.sesion0112.ejerciciosExamen.ejercicios.ejercicio1;

/*
Ejercicio 1: Un banco tiene un cajero automático que funciona como un sistema productor-consumidor.
El sistema central del banco (productor) repone efectivo en el cajero, mientras que los clientes (consumidores) retiran dinero.
Implementa un programa que simule este flujo, con un buffer que represente el efectivo disponible y una capacidad máxima que limite la cantidad de dinero en el cajero.
Asegúrate de que los clientes esperen si el cajero está vacío y el sistema central espere si está lleno.
 */
public class Cajero{
    private int efectivoDisponible = 1000;
    private int limiteDinero = 5000;


    public synchronized void retirarDinero(int dineroRetirado) {
        while (efectivoDisponible < dineroRetirado) {
            try {
                System.out.println("Esperando a que el cajero tenga suficiente efectivo...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        efectivoDisponible -= dineroRetirado;
        System.out.println("Se ha retirado " + dineroRetirado + " euros");
        System.out.println("Saldo: " + efectivoDisponible);
        notifyAll();
    }

    public synchronized void reponerDinero(int dineroRepuesto) {
        while (efectivoDisponible + dineroRepuesto > limiteDinero) {
            try {
                System.out.println("Esperando a que el cajero este vacío");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            efectivoDisponible += dineroRepuesto;
            System.out.println("Se ha repuesto " + dineroRepuesto + " euros");
            System.out.println("Saldo: " + efectivoDisponible);
        }

    }

    public static void main(String[] args) {
        Cajero cajero = new Cajero();

        Cliente cliente1 = new Cliente("Iker", 500, cajero);
        Cliente cliente2 = new Cliente("Roberto", 500, cajero);

        Banco banco = new Banco("NegreiraBank", cajero);

        banco.start();
        cliente1.start();
        cliente2.start();

    }
}
