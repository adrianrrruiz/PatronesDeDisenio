/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Composite
 * Tipo de Clase: Java
 * Clase que simula un punto de venta.
 */
package composicion.ordenes;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import composicion.productos.AbstraccionProducto;


/**
 *
 * @author Fabrizio Bolaño
 */
public class OrdenVenta {
    private long CodigoOrden;
    private String Cliente;
    private List<AbstraccionProducto> productos = new ArrayList<AbstraccionProducto>();

    public OrdenVenta(long CodigoOrden, String Cliente) {
        super();
        this.CodigoOrden = CodigoOrden;
        this.Cliente = Cliente;
    }

    public double getPrecio() {
        double preciolocal = 0d;
        for (AbstraccionProducto child : productos) {
            preciolocal += child.getPrecio();
        }
        return preciolocal;
    }

    public void AgregarProducto(AbstraccionProducto producto) {
        productos.add(producto);
    }

    public void ImprimirOrdenVenta() {

        NumberFormat formater = new DecimalFormat("###,##0.00");
        System.out.println("\\\n============================================="
                + "\nCodigo_Orden: " + CodigoOrden + "\nCliente: " + Cliente
                + "\nProductos:\n");
        for (AbstraccionProducto prod : productos) {
            System.out.println(prod.getNombre() + "\t\t\t$ "
                    + formater.format(prod.getPrecio()));
        }
        System.out.println("Total: " + formater.format(getPrecio())
                + "\n=============================================");
    }

    public long getCodigoOrden() {
        return CodigoOrden;
    }

    public void setCodigoOrden(long CodigoOrden) {
        this.CodigoOrden = CodigoOrden;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public List<AbstraccionProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<AbstraccionProducto> productos) {
        this.productos = productos;
    }



}