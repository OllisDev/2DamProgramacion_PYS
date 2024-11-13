package Tema2_Hilos.sesion1311;

public class Cliente extends Thread{
    simulacionBanco banco = null;

    public Cliente (simulacionBanco bank) {
        this.banco = bank;
    }

    @Override
    public void run () {
        System.out.println("hilo comprando...");
        banco.compra(300);
    }
}
