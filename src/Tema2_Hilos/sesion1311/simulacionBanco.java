package Tema2_Hilos.sesion1311;

public class simulacionBanco {
    // recurso compartido
  private int saldo = 600;

    public simulacionBanco() {

    }

    public synchronized void compra (int precio) {
        if (this.saldo > 0) {
            System.out.println("Tramitando compra...");
            this.saldo = this.saldo - precio;
            System.out.println("Saldo: " + this.saldo);
        }
    }

    public static void main(String[] args) {
        simulacionBanco NegreiraBank = new simulacionBanco();
        Cliente cliente1 = new Cliente(NegreiraBank);
        Cliente cliente2 = new Cliente(NegreiraBank);
        Cliente cliente3 = new Cliente(NegreiraBank);
        cliente1.start();
        cliente2.start();
        cliente3.start();
    }



}
