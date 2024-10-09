/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Facade
 * Tipo de Clase: Java
 * Clase para simular sistema CRM.
 */
package crm;
import utilidades.Cliente;
import utilidades.DatosBDSimulada;


/**
 *
 * @author Fabrizio Bolaño
 */
public class SistemaCRM {

    public Cliente BuscarCliente(Long clienteId){
        return DatosBDSimulada.BuscarClienteId(clienteId);
    }
}
