/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Proxy
 * Tipo de Clase: Java
 */
package implementacion;

import patronfactorymethod.FactoryProxy;

/**
 *
 * @author Fabrizio Bolaño
 */
public class FabricaServicios {
    // Parámetro que permite elegir el tipo de proxy
    public static InterfaceProcesos CrearEjecucionProceso() {
        return FactoryProxy.getDefaultProxyAdapter();
    }
}