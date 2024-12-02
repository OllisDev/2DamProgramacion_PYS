package Tema2_Hilos.sesion0112.ejerciciosExamen.ejerciciosBasicos.ejercicio2;
/*
Ejercicio 2: Un banco maneja transferencias entre cuentas mediante un sistema compartido.
Los productores son las transacciones entrantes, que aumentan el saldo de las cuentas, y los consumidores son las transferencias salientes, que lo disminuyen.
Simula este escenario con un buffer que represente el flujo de transferencias en proceso,
asegurando que nunca se realicen transferencias que dejen las cuentas con saldo negativo y que las transacciones se procesen en orden.
 */

public class Banco {
    private int saldo;
    private String name;

    public Banco(int saldo, String name) {
        this.saldo = saldo;
        this.name = name;
    }

    public synchronized void transacciones(int aumentoSaldo) {
        System.out.println("Se ha realizado una transacción");
        this.saldo += aumentoSaldo;
        System.out.println("Saldo: " + this.saldo);
        notifyAll();
    }

    public synchronized void transferencias(int desaumentoSaldo) throws InterruptedException {
        while (saldo < desaumentoSaldo) {
            System.out.println("El saldo es insuficiente. Esperando a que haya saldo...");
            wait();
        }
        this.saldo-= desaumentoSaldo;
        System.out.println("Se ha realizado una transferencia");
        System.out.println("Saldo: " + this.saldo);
    }

    public static void main(String[] args) {
        Banco banco = new Banco(500, "NegreiraBank");
        Cuenta productor = new Cuenta(true, banco);
        Cuenta consumidor = new Cuenta(false, banco);

        productor.start();
        consumidor.start();

        try {
            productor.join();
            consumidor.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
