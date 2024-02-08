package kass.concurrente.modelo.cuchillo;

/**
 * Interfaz que simulara un cuchillo
 * @author Kassandra Mirael
 * @version 1.0
 */
public interface Cuchillo {

    /**
     * Metodo que hace que cocine mas rapido al usar el cuchillo
     * @return El tiempo que reduce al usar dicho item
     */
    public Integer corta();

    /**
     * Clase interna para modelar un cuchillo implementando {@code Cuchillo}
     */
    public class CuchilloChef implements Cuchillo {
       /**
        * Metodo que implementa el comportamiento de {@code corta()} definido en la interfaz {@code Cuchillo}
        */
       @Override
       public Integer corta() {
           return 5;
       } 
    }
}
