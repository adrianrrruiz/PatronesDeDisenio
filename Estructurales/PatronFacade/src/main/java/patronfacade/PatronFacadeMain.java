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

        SolicitudPago request2 = new SolicitudPago();
        request2.setMonto(100);
        request2.setFechaExpiracionTarjeta("10/2025");
        request2.setNombreTarjeta("Luis Diaz");
        request2.setNumeroTarjeta("1234567890123456");
        request2.setNumeroSeguridadTarjeta("345");
        request2.setClienteId(2L);

//        PAGO CON PUNTOS
        SolicitudPago request3 = new SolicitudPago();
        request3.setMonto(50);
        request3.setFechaExpiracionTarjeta("10/2025");
        request3.setNombreTarjeta("Sadio Mane");
        request3.setNumeroTarjeta("1234567890123456");
        request3.setNumeroSeguridadTarjeta("345");
        request3.setClienteId(3L);

        SolicitudPago request4 = new SolicitudPago();
        request4.setMonto(200);
        request4.setFechaExpiracionTarjeta("10/2025");
        request4.setNombreTarjeta("Alisson Becker");
        request4.setNumeroTarjeta("1234567890123456");
        request4.setNumeroSeguridadTarjeta("345");
        request4.setClienteId(4L);

        try {
            InterfaceFacadePago paymentFacade = new FachadaPagoLinea();
            paymentFacade.pago(request);
            paymentFacade.pago(request2);
            paymentFacade.pago(request3);
            paymentFacade.pago(request4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}