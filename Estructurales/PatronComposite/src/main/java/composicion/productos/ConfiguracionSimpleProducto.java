/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Composite
 * Tipo de Clase: Java
 * Representa la forma más básica de un producto.
 * No podrá estar compuesta por otros elementos.
 */
package composicion.productos;

/**
 *
 * @author Fabrizio Bolaño
 */
public class ConfiguracionSimpleProducto extends AbstraccionProducto {
    protected String marca;

    public ConfiguracionSimpleProducto(String nombre, double precio, String marca) {
        super(nombre, precio);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}