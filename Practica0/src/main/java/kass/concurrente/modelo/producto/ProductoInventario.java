package kass.concurrente.modelo.producto;

/**
 * Clase que modela un producto de un inventario
 * @author Kassandra Mirael
 */
public class ProductoInventario extends Producto{
    private static final Integer TIEMPOR = 5000; // Tiempo general que toma reaprovisionar
    protected Integer qty; // Cantidad en el inventario

    /**
     * Constructor de ProductoInventario
     * @param nombre el nombre que asignado al objeto
     * @param precio el precio al que se vende el objeto
     */
    public ProductoInventario(String nombre, Double precio) {
        super(nombre, precio);
        this.qty = 0;
    }

    /**
     * Constructor de ProductoInventario
     * @param nombre el nombre que asignado al objeto
     * @param precio el precio al que se vende el objeto
     * @param qty    la cantidad de objetos en el inventario
     */
    public ProductoInventario(String nombre, Double precio, Integer qty) {
        super(nombre, precio);
        this.qty = qty;
    }

    /**
     * Metodo que regresa la cantidad de objetos en inventario
     * @return cantidad de objetos en inventario ({@code qty})
     */
    public Integer getQty() {
        return qty;
    }

    /**
     * Metodo que indica si aun existen objetos en el inventario ({@code qty > 0})
     * @return {@code true} si hay objetos en el inventario
     */
    public boolean enInventario() {
        return qty > 0;
    }

    /**
     * Metodo que simula el tiempo que tomaria reaprovisionar un objeto y aumenta las existencias en el inventario a 10
     */
    private void reaprovisionar() {
        try {
            System.out.println("[WARN] Sin " + getNombre() + " en el inventario, reaprovisionando. TE: " + (TIEMPOR / 1000) + "s."); // Imprime un log con el nombre y tiempo que tomara la accion
            Thread.sleep(TIEMPOR); // "Duerme" el thread actual la cantidad de tiempo establecido
            this.qty = 10;         // Reestablece la cantidad de objetos en inventarioa 10
        } catch (InterruptedException e) {
            System.err.println(e);
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * Metodo para obtener un objeto del inventario. Revisa primero si aun hay existencias, si no las hay, usa {@code reaprovisiona()}
     */
    public void tomarProducto() {
        if (!enInventario()) {
            reaprovisionar();
        }
        qty--;
    }

    @Override
    public String toString() {
        return "Producto: " + getNombre() + ", precio unitario: " + getPrecio() + ", disponible: " + getQty();
    }
}
