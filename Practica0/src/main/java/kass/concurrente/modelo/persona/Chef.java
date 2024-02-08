package kass.concurrente.modelo.persona;

import kass.concurrente.modelo.cuchillo.Cuchillo;
import kass.concurrente.modelo.producto.Platillo;
import kass.concurrente.modelo.producto.Producto;
import kass.concurrente.modelo.producto.ProductoInventario;

/**
 * Clase que modela al chef extendiendo de {@code Persona}
 * @author Diego P.
 * @see Persona
 */
public class Chef extends Persona {
    protected Integer edad; // Edad
    protected Cuchillo cu;  // Cuchillo

    /**
     * Constructor de Chef
     * @param nombre el nombre del chef
     * @param edad   la edad del chef
     * @param cu     el cuchillo del chef
     * @see Cuchillo
     */
    public Chef(String nombre, Integer edad, Cuchillo cu) {
        super(nombre);
        this.edad = edad;
        this.cu = cu;
    }

    /**
     * Metodo para que el chef prepare un platillo. Simula el tiempo que le toma prepararlo
     * @param platillo el platillo a preparar
     */
    public void preparaPlatillo(Platillo platillo) {
        /* Calcula el tiempo de coccion basado en la resta del tiempo del platillo menos el tiempo que quita el cuchillo.
         * Se evitan los negativos al decidir si esta resta es menor a 0, si es el caso establece directo a 0.
         * Con un resultado positivo, multiplica la resta por 1000 para operar con segundos
        */
        Integer tiempoCoccion = platillo.getTiempoCoccion() - cu.corta() < 0 ? 0 
        : (platillo.getTiempoCoccion() - cu.corta()) * 1000; 

        try {
            // Muestra un log con la informacion del platillo en preparacion y su tiempo
            System.out.println("[INFO] Preparando: " + platillo.getNombre() + " ... TE: " + (tiempoCoccion / 1000) + "s.");
            Thread.sleep(tiempoCoccion); // Duerme el thread actual por el tiempo establecido para simular el tiempo de coccion del platillo

            // Recorre la lista de productos del platillo para recuperar info
            for (Producto producto: platillo.getProductosRequeridos()) {
                ProductoInventario prod = (ProductoInventario) producto; // Castea a `ProductoInventario` para operar
                prod.tomarProducto(); // Toma un producto del inventario para simular su preparacion
            }

        } catch (InterruptedException e) {
            System.err.println(e);
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * Metodo para que el chef atienda a un comensal
     * @param comensal el comensal que se atiende
     * @see Comensal
     */
    public void atiendeComensal(Comensal comensal) {
        // Se obtienen todos los platillos en la orden del comensal
        for (Platillo platillo : comensal.getOrden()) {
            preparaPlatillo(platillo); // Se prepara cada platillo
        }

        // Verifica si hay que despachar productos individuales al comensal
        if (!comensal.getProductosIndividuales().isEmpty()) {
            // Recorrer la lista de productos individuales del comensal
            for (Producto producto : comensal.getProductosIndividuales()) {
                ProductoInventario prod = (ProductoInventario) producto; // Casteo a `ProdcutoInventario` para operar con el inventario
                System.out.println("[INFO] Despachando: " + prod.getNombre() + " ..."); // Log con info
                prod.tomarProducto(); // Se toma el producto del inventario
            }
        }
    }
}
