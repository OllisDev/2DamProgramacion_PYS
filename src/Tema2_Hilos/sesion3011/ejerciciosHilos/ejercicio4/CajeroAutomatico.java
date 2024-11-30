package Tema2_Hilos.sesion3011.ejerciciosHilos.ejercicio4;
/*
Ejercicio 4: Simula un cajero automático compartido entre varios hilos.
Cada hilo representa a una persona que realiza operaciones en la cuenta:
 - Algunos hilos realizan depósitos.
 - Otros hilos realizan retiros.
Implementa sincronización para garantizar que las operaciones no generen inconsistencias.
Si un hilo intenta retirar más dinero del disponible, debe imprimir "Saldo insuficiente".
 */
public class CajeroAutomatico {
    private int saldo = 600;

    public CajeroAutomatico(int saldo) {
        this.saldo = saldo;
    }

    public synchronized void depositar(int deposito) {
        System.out.println(Thread.currentThread().getName() + " ha depostidado: " + deposito + " euros");
        this.saldo += deposito;
        System.out.println("Saldo: " + this.saldo);
    }

    public synchronized void retirar(int retiro) {
        if (retiro <= this.saldo) {
            System.out.println(Thread.currentThread().getName() + " ha retirado: " + retiro + " euros");
            this.saldo -= retiro;
            System.out.println("Saldo: " + this.saldo);
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public static void main(String[] args) {
        CajeroAutomatico cajero = new CajeroAutomatico(600);

        Thread persona1 = new Thread(new PersonaRobo("Laporta", cajero), "Laporta");
        Thread persona2 = new Thread(new PersonaRobo("Tebas", cajero), "Tebas");
        Thread persona3 = new Thread(new PersonaRobo("Pedro Sanchez", cajero), "Pedro Sanchez");

        persona1.start();
        persona2.start();
        persona3.start();
    }

}
