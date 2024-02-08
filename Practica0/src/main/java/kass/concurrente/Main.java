package kass.concurrente;

import java.util.ArrayList;
import java.util.List;

import kass.concurrente.modelo.cuchillo.Cuchillo.CuchilloChef;
import kass.concurrente.modelo.persona.Chef;
import kass.concurrente.modelo.persona.Comensal;
import kass.concurrente.modelo.producto.Platillo;
import kass.concurrente.modelo.producto.Producto;
import kass.concurrente.modelo.producto.ProductoInventario;

/**
 * Clase Main
 * Aqui va toda tu simulacion
 * Genera un par de clientes para que los atienda el chef
 * @author Kassandra Mirael
 * @version 1.0
 */
public class Main {
    public static final String SEPARADOR  = "[INFO] ----------------------------------------------------------- ";
    public static final String INFOTAG = "[INFO] ";
    public static void main(String[] args) {

        System.out.println(INFOTAG + "Iniciando ejecucion");

        /* Ganancias del dia */
        Double gananciasDia = 0.;

        /* Chef */
        Chef chef1 = new Chef("Chefsito", 30, new CuchilloChef());
        System.out.println(INFOTAG + "Chef a cargo: " + chef1.getNombre());


        /* Comensales */
        List<Comensal> comensales = new ArrayList<>(); // Crear una lista para todos los comensales
        
        // Inicializar Comensal(es)
        Comensal comensalA = new Comensal("Comensal A");
        Comensal comensalB = new Comensal("Comensal B");
        Comensal comensalC = new Comensal("Comensal C");
        
        // Agregar comensal(es) a la lista
        comensales.add(comensalA);
        comensales.add(comensalB);
        comensales.add(comensalC);


        /* Inventario */
        ProductoInventario tortillas = new ProductoInventario("tortillas", 2., 5);
        ProductoInventario bolillo   = new ProductoInventario("bolillo", 2.5, 1);
        ProductoInventario carnitas  = new ProductoInventario("carnitas", 5., 10);
        ProductoInventario suadero   = new ProductoInventario("suadero", 5.5, 2);
        ProductoInventario cilantro  = new ProductoInventario("cilantro", 1.5, 10);
        ProductoInventario cebolla   = new ProductoInventario("cebolla", 2., 10);
        ProductoInventario salsa     = new ProductoInventario("salsa", 3.5, 10);
        ProductoInventario jamaica   = new ProductoInventario("jamaica", 5.5, 2);
        ProductoInventario horchata  = new ProductoInventario("horchata", 5.5, 5);
        Producto[] inventario = {tortillas, bolillo, carnitas, suadero, cilantro, cebolla, salsa, jamaica, horchata};


        /* Platillos */
        // Taco de carnitas
        List<Producto> tacoCarnitasIngredientes = new ArrayList<>(); // Crear la lista de Productos para los ingredientes
        tacoCarnitasIngredientes.add(inventario[0]); // Tortillas
        tacoCarnitasIngredientes.add(inventario[2]); // Carnitas
        tacoCarnitasIngredientes.add(inventario[6]); // Salsa
        Platillo tacoCarnitas = new Platillo(tacoCarnitasIngredientes, 15., 6, "Taco de carnitas"); // Crear el platillo

        // Taco de suadero
        List<Producto> tacoSuaderoIngredientes = new ArrayList<>();
        tacoSuaderoIngredientes.add(inventario[0]); // Tortillas
        tacoSuaderoIngredientes.add(inventario[3]); // Suadero
        tacoSuaderoIngredientes.add(inventario[6]); // Salsa
        Platillo tacoSuadero = new Platillo(tacoSuaderoIngredientes, 12.5, 7, "Taco de suadero");
        
        // Torta de carnitas
        List<Producto> tortaCarnitasIngredientes = new ArrayList<>();
        tortaCarnitasIngredientes.add(inventario[1]); // Bolillo
        tortaCarnitasIngredientes.add(inventario[2]); // Carnitas
        tortaCarnitasIngredientes.add(inventario[6]); // Salsa
        Platillo tortaCarnitas = new Platillo(tortaCarnitasIngredientes, 15.5, 10, "Torta de carnitas");


        /* Orden(es) de comensal(es) */
        System.out.println(SEPARADOR);
        // Comensal A
        Platillo comensalATacoSuadero = new Platillo(tacoSuadero); // Taco custom, se crea un nuevo objeto para no alterar el ya establecido
        comensalATacoSuadero.agregaProducto(cilantro); // Agregar ingrediente (Producto) extra
        comensalATacoSuadero.agregaProducto(cebolla);
        comensalATacoSuadero.calculaPrecio();          // Calcular el nuevo precio basados en los ingredientes (Producto) extra
        comensalA.agregaAOrden(comensalATacoSuadero); // Agregar Platillo a la orden el comensal
        comensalA.agregaAOrden(comensalATacoSuadero);
        comensalA.agregaAOrden(tacoCarnitas);
        comensalA.agregaAOrden(tacoSuadero);
        comensalA.agregaAOrden(jamaica); // Agregar Producto a la orden del comensal
        
        // Comensal B
        comensalB.agregaAOrden(tacoCarnitas);
        comensalB.agregaAOrden(tacoSuadero);
        comensalB.agregaAOrden(tacoSuadero);
        comensalB.agregaAOrden(jamaica);

        // Comensal C
        comensalC.agregaAOrden(tacoCarnitas);
        comensalC.agregaAOrden(jamaica);
        comensalC.agregaAOrden(horchata);
        comensalC.agregaAOrden(tortaCarnitas);

        // Mostrar resumen de orden para comensal(es)
        for (Comensal comensal : comensales) {
            System.out.println(INFOTAG + comensal.getNombre() + " ordena:");
            System.out.println(comensal.getResumenOrden());
            System.out.println(INFOTAG + "Total de la orden: " + comensal.getTotalOrden());
        }


        /* Chef atiende comensal(es) */
        System.out.println(SEPARADOR);
        // Atender a comensal(es) en la lista
        for (Comensal comensal : comensales) {
            System.out.println(INFOTAG + "Atendiendo a " + comensal.getNombre());
            chef1.atiendeComensal(comensal);
            gananciasDia += comensal.getTotalOrden(); // Obtener el total de la orden y sumarlo a las ganancias del dia
        }

        /* Mostar ganancias del dia */
        System.out.println(SEPARADOR);
        System.out.println(INFOTAG + "Ganancias del dia: " + gananciasDia);

        /* Mostrar inventario */
        System.out.println(SEPARADOR);
        System.out.println(INFOTAG + "Estado del inventario:");
        for (Producto producto : inventario) {
            ProductoInventario prod = (ProductoInventario) producto;
            System.out.println(INFOTAG + prod.toString());
        }
    }
}