package Tema2_Hilos.sesion3011.ejerciciosHilos.ejercicio4;

public class PersonaRobo implements Runnable{
    String name;
    CajeroAutomatico cajero = null;

    public PersonaRobo(String name, CajeroAutomatico cajero) {
        this.name = name;
        this.cajero = cajero;
    }

    @Override
    public void run() {
        cajero.depositar(300);
        cajero.retirar(300);
    }
}
