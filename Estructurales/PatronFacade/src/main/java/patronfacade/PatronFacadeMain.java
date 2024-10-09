/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Facade
 * Tipo de Clase: Main()
 */

package patronfacade;
import implementacion.InterfaceFacadePago;
import implementacion.FachadaPagoLinea;
import implementacion.SolicitudPago;
/**
 *
 * @author Fabrizio Bolaño
 */
public class PatronFacadeMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SolicitudPago request = new SolicitudPago();
        request.setMonto(499);
        request.setFechaExpiracionTarjeta("10/2025");
        request.setNombreTarjeta("Mo Salah");
        request.setNumeroTarjeta("1234567890123456");
        request.setNumeroSeguridadTarjeta("345");
        request.setClienteId(1L);

        try {
            InterfaceFacadePago paymentFacade = new FachadaPagoLinea();
            paymentFacade.pago(request);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}