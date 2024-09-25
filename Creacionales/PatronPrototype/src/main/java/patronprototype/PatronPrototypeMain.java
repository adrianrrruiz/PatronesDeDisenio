/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Creacional - > Prototype
 * Tipo de Clase: Main()
 */
package patronprototype;

import implementacion.CatalogoProductos;
import implementacion.FabricaPrototype;
import implementacion.ListaPrecios;
/**
 *
 * @author Fabrizio Bolaño
 */
public class PatronPrototypeMain {

    public static void main(String[] args) {


        //Creación de la Lista Inicial de Precios

        ListaPrecios listadoEstandar = new ListaPrecios("Lista Estándar de Precios");
        for(int c = 1; c<=5; c++){
            CatalogoProductos item = new CatalogoProductos("Producto " + c, c*2);
            listadoEstandar.addCatalogoItem(item);
        }

        //Segunda lista para clientes mayoristas.
        //Se obtiene del listado estándar con un 10% de descuento.

        FabricaPrototype.addPrototype(listadoEstandar.getListado(), listadoEstandar);

        ListaPrecios listadoPorMayor = (ListaPrecios)
                FabricaPrototype.getPrototype("Lista Estándar de Precios");
        listadoPorMayor.setListado("Listado de Precios al Por Mayor");

        for(CatalogoProductos item : listadoPorMayor.getProductos()){
            item.setPrecioProducto(item.getPrecioProducto()*0.90);
        }
        FabricaPrototype.addPrototype(listadoPorMayor.getListado(), listadoPorMayor);

        //Tercera lista de precios para clientes Especiales.
        //Se obtiene de la listado Mayorista menos un 10%.
        ListaPrecios listadoClientesEspeciales = (ListaPrecios)
                FabricaPrototype.getPrototype("Listado de Precios al Por Mayor");
        listadoClientesEspeciales.setListado("Listado de Precios Clientes Especiales");

        for(CatalogoProductos item : listadoClientesEspeciales.getProductos()){
            item.setPrecioProducto(item.getPrecioProducto()*0.90);
        }

        //Cuarta lista para clientes mayoristas.
        //Se obtiene del listado estándar con un 19% de descuento del IVA
        ListaPrecios listadoConIva19 = (ListaPrecios)
                FabricaPrototype.getPrototype("Lista Estándar de Precios");
        listadoConIva19.setListado("Listado de Precios con 19% de IVA");

        for(CatalogoProductos item : listadoConIva19.getProductos()){
            item.setPrecioProducto(item.getPrecioProducto()*1.19);
        }

        //Quinta lista para clientes mayoristas.
        //Se obtiene del listado estándar con un 5% de descuento del IVA
        ListaPrecios listadoConIva5 = (ListaPrecios)
                FabricaPrototype.getPrototype("Lista Estándar de Precios");
        listadoConIva5.setListado("Listado de Precios con 5% de IVA");

        for(CatalogoProductos item : listadoConIva5.getProductos()){
            item.setPrecioProducto(item.getPrecioProducto()*1.05);
        }

        //Imprimimos las diferentes listas.
        System.out.println(listadoEstandar);
        System.out.println(listadoPorMayor);
        System.out.println(listadoClientesEspeciales);
        System.out.println(listadoConIva19);
        System.out.println(listadoConIva5);


    }

}