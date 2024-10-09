/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Facade
 * Tipo de Clase: Java
 */
package implementacion;

/**
 *
 * @author Fabrizio Bolaño
 */
public interface InterfaceFacadePago {
    public RespuestaPago pago(SolicitudPago solicitudPago)throws ErrorGeneralPago;
}