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
    protected double tasaImpuesto;
    protected int cantidad;

    public AbstraccionProducto(String nombre, double precio, double tasaImpuesto, int cantidad) {
        super();
        this.nombre = nombre;
        this.precio = precio;
        this.tasaImpuesto = tasaImpuesto;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio * cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTasaImpuesto() {return tasaImpuesto;}

    public void setTasaImpuesto(double tasaImpuesto) {this.tasaImpuesto = tasaImpuesto;}

    public int getCantidad() {return cantidad;}

    public void setCantidad(int cantidad) {this.cantidad = cantidad;}
}
