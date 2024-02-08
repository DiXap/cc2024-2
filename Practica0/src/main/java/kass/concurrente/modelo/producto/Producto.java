package kass.concurrente.modelo.producto;

/**
 * Clase que modela un producto
 * @author Kassandra Mirael
 */
public class Producto {
    protected Double precio; // Precio del producto
    protected String nombre; // Nombre del producto
    
    /**
     * Constructor vacio de Producto
     */
    public Producto() {
        this.precio = 0.;
        this.nombre  = "";
    }

    /**
     * Constructor de Prodcuto
     * @param nombre el nombre del producto
     * @param precio el precio del producto
     */
    public Producto(String nombre, Double precio) {
        this.nombre  = nombre;
        this.precio = precio;
    }

    /**
     * Metodo para obtener el precio del producto
     * @return el precio del producto
     */
    public Double getPrecio() {
        return this.precio;
    }

    /**
     * Metodo para obtener el nombre del producto
     * @return el nombre del producto
     */
    public String getNombre() {
        return this.nombre;
    }
}
