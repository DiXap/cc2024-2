package kass.concurrente.modelo.producto;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que modela un platillo
 * @author Kassandra Mirael
 */
public class Platillo {
    protected List<Producto> productos; // Lista de Producto (ingredientes) que conforman el objeto
    protected String nombre;   // Nombre del platillo
    protected Double precio;   // Precio del platillo
    protected Integer tiempoC; // Tiempo de coccion

    /**
     * Constructor vacio para un objeto Platillo
     */
    public Platillo() {
        this.productos = new ArrayList<>();
        this.nombre  = "";
        this.precio  = 0.;
        this.tiempoC = 0;
    }

    /**
     * Constructor de Platillo
     * @param nombre        el nombre del platillo
     * @param tiempoCoccion el tiempo de coccion del platillo
     */
    public Platillo(String nombre, Integer tiempoCoccion) {
        this.productos = new ArrayList<>();
        this.nombre  = nombre;
        this.precio  = 0.;
        this.tiempoC = tiempoCoccion;
    }

    /**
     * Constructor de Platillo, toma una lista de ingredientes ({@code Producto})
     * @param productos     la lista de Producto que representan ingredientes
     * @param precio        el precio del platillo
     * @param tiempoCoccion el tiempo de coccion del platillo
     * @param nombre        el nombre del platillo
     * @see Prodcuto
     */
    public Platillo(List<Producto> productos, Double precio, Integer tiempoCoccion, String nombre) {
        this.productos = new ArrayList<>(productos);
        this.nombre  = nombre;
        this.precio  = precio;
        this.tiempoC = tiempoCoccion;
    }

    /**
     * Constructor copia de Platillo
     * @param otroPlatillo el otro platillo a copiar
     */
    public Platillo(Platillo otroPlatillo) {
        this.productos = new ArrayList<>(otroPlatillo.getProductosRequeridos());
        this.nombre  = otroPlatillo.getNombre();
        this.precio  = otroPlatillo.getPrecio();
        this.tiempoC = otroPlatillo.getTiempoCoccion();
    }

    /**
     * Este metodo calcula el precio sobre el precio de los items, se ignora
     * el precio base.
     * @return El precio de la suma de cada item utilizado
     */
    public Double calculaPrecio(){
        Double precioProductos = 0.; // Inicializar el total

        // Iterar todos los productos en su lista
        for (Producto producto : productos) {
            precioProductos += producto.getPrecio(); // Obtener el precio y sumarlo al total
        }
        this.precio = precioProductos; // Actualizar el precio del platillo

        return precioProductos;
    }
    
    /**
     * Metodo para obtener el nombre del platillo
     * @return el nombre del platillo
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Metodo para obtener el precio del platillo
     * @return el precio del platillo
     */
    public Double getPrecio() {
        return this.precio;
    }

    /**
     * Metodo para obtener el tiempo de coccion del platillo
     * @return el tiempo de coccion del platillo
     */
    public Integer getTiempoCoccion() {
        return this.tiempoC;
    }

    /**
     * Metodo para obtener la lista de productos del platillo
     * @return el lista de productos del platillo
     */
    public List<Producto> getProductosRequeridos() {
        return this.productos;
    }

    /**
     * Metodo para agregar un {@code Producto} a la lista de productos
     * @see Producto
     */
    public void agregaProducto(Producto producto) {
        this.productos.add(producto);
    }
}
