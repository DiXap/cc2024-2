package kass.concurrente.modelo.persona;

import java.util.ArrayList;
import java.util.List;

import kass.concurrente.modelo.producto.Platillo;
import kass.concurrente.modelo.producto.Producto;

/**
 * Clase que modela un comensal extendiendo la funcionalidad de {@code Persona}
 * @author Diego P.
 * @see Persona
 */
public class Comensal extends Persona {
    private List<Platillo> orden; // La lista de platillos en la orden del comensal
    private List<Producto> productosIndividuales; // Lista de productos individuales
    private Double totalOrden; // Total de la orden

    /**
     * Constructor de comensal
     * @param nombre el nombre del comensal
     */
    public Comensal(String nombre) {
        super(nombre);
        this.orden = new ArrayList<>();
        this.productosIndividuales = new ArrayList<>();
        this.totalOrden = 0.;
    }

    /**
     * Metodo oara obtener la lista de platillos (orden)
     * @return la lista de platillos
     */
    public List<Platillo> getOrden() {
        return this.orden;
    }

    /**
     * Metodo oara obtener la lista de producto individuales que desea adquirir el comensal
     * @return la lista de productos individuales
     */
    public List<Producto> getProductosIndividuales() {
        return productosIndividuales;
    }

    /**
     * Metodo para agregar un platillo a la orden del comensal
     * @param platillo el platillo a agregar
     */
    public void agregaAOrden(Platillo platillo) {
        Platillo dummy = new Platillo(platillo);
        this.orden.add(dummy);
        this.totalOrden += dummy.getPrecio();
    }

    /**
     * Metodo para agregar un producto individual a la orden del comensal
     * @param producto el producto que se agrega
     */
    public void agregaAOrden(Producto producto) {
        this.productosIndividuales.add(producto);
        this.totalOrden += producto.getPrecio();
    }

    /**
     * Metodo para obtener la informacion de la orden del comensal
     * @return la informacion de la orden
     */
    public String getResumenOrden() {
        StringBuilder resumen = new StringBuilder(); // String builder porque SonarLint se quejaba
        // Recorrer la orden por indices
        for (int i = 0; i < this.orden.size(); i++) {
            resumen.append("[INFO] Platillo: " + this.orden.get(i).getNombre() + " ("); // Agregar string de info
            
            // Para cada platillo recorrer la lista con sus productos (ingredientes)
            for (Producto producto : this.orden.get(i).getProductosRequeridos()) {
                resumen.append(" " + producto.getNombre());
            }
            
            resumen.append("). Precio: " + this.orden.get(i).getPrecio());

            // Agregar salto de linea siempre y cuando no sea el ultimo platillo de la orden
            if (i < this.orden.size() - 1) {
                resumen.append("\n");
            }
        }

        // Revisar si la lista de productos individuales tiene productos dentro
        if (!this.productosIndividuales.isEmpty()) {
            resumen.append("\n");
            // Recorrer toda la lista de productos individuales y agregar su informacion al string final
            for (int i = 0; i < this.productosIndividuales.size(); i++) {
                resumen.append("[INFO] Producto individual: " + this.productosIndividuales.get(i).getNombre());
                resumen.append(". Precio: " + this.productosIndividuales.get(i).getPrecio());

                if (i < this.productosIndividuales.size() - 1) {
                    resumen.append("\n");
                }
            }
        }

        return resumen.toString();
    }

    /**
     * Metodo para obtener el total de la orden
     * @return el total de la orden
     */
    public Double getTotalOrden() {
        return this.totalOrden;
    }
}
