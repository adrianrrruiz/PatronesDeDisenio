/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Composite
 * Tipo de Clase: Abstracta
 */

package composicion.productos;

/**
 *
 * @author Fabrizio Bolaño
 */
public abstract class AbstraccionProducto {
    protected String nombre;
    protected double precio;

    public AbstraccionProducto(String nombre, double precio) {
        super();
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
