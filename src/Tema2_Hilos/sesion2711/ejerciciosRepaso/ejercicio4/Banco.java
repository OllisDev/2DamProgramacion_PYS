package Tema2_Hilos.sesion2711.ejerciciosRepaso.ejercicio4;
/*
Ejercicio 4: Crea un programa que simule una cuenta bancaria compartida por varios hilos, cada uno representando a una persona que deposita o retira dinero.
Utiliza sincronización para evitar problemas de consistencia en el saldo de la cuenta.
Usa Synchronized.
 */
public class Banco {
    private int saldo = 600;

    public Banco(int saldo) {
        this.saldo = saldo;
    }

    public synchronized void depositar(int dineroDepositado) {
        System.out.println(Thread.currentThread().getName() + " esta depositando " + dineroDepositado + " euros");
        this.saldo += dineroDepositado;
        System.out.println("Saldo: " + this.saldo + " euros");

    }

    public synchronized void retirar(int dineroRetirado) {
        if(dineroRetirado <= this.saldo) {
            System.out.println(Thread.currentThread().getName() + " esta retirando " + dineroRetirado + " euros");
            this.saldo -= dineroRetirado;
            System.out.println("Saldo: " + this.saldo);
        } else {
            System.out.println("No se puede realizar la operación. Debido a que saldo es negativo.");
        }
    }

    public static void main(String[] args) {
        Banco Negreiraank = new Banco(600);
        Thread persona1 = new Thread(new Persona("Negreira", Negreiraank), "Negreira");
        Thread persona2 = new Thread(new Persona("Laporta", Negreiraank), "Laporta");
        Thread persona3 = new Thread(new Persona("Infantino", Negreiraank), "Infantino");

        persona1.start();
        persona2.start();
        persona3.start();
    }


}
