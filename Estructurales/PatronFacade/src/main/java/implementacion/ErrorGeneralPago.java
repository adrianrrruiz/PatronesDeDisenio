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
public class ErrorGeneralPago extends Exception {
    public ErrorGeneralPago(String message) {
        super(message);
    }
}