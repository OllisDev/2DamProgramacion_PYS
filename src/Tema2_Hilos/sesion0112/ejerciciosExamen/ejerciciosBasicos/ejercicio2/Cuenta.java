package Tema2_Hilos.sesion0112.ejerciciosExamen.ejerciciosBasicos.ejercicio2;

public class Cuenta extends Thread {
    private final boolean esProductor;
    private final Banco banco;

    public Cuenta(boolean esProductor, Banco banco) {
        this.esProductor = esProductor;
        this.banco = banco;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) { // Simula 5 operaciones por cada hilo
                if (esProductor) {
                    int monto = (int) (Math.random() * 500) + 100; // Transacción con monto aleatorio
                    banco.transacciones(monto);
                } else {
                    int monto = (int) (Math.random() * 400) + 100; // Transferencia con monto aleatorio
                    banco.transferencias(monto);
                }
                Thread.sleep(200); // Simular un tiempo de espera entre operaciones
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

