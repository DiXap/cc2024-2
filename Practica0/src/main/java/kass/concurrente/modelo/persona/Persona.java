package kass.concurrente.modelo.persona;

/**
 * Clase que modela una persona
 * @author Kassandra Mirael
 */
public class Persona {
    protected String nombre; // Atributo nombre

    /**
     * Constructor de la clase {@code Persona}  
     * @param nombre el nombre que se asignara al objeto
     */
    public Persona(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que regresa el atributo {@code nombre} del objeto 
     * @return el nombre del objeto
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Metodo que modifica el atributo {@code nombre} del objeto 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
