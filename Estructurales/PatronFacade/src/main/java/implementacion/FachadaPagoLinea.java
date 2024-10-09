/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Facade
 * Tipo de Clase: Java
 */
package implementacion;
import java.util.HashMap;
import financiera.SistemaBancario;
import financiera.SolicitudTransferencia;
import facturador.SistemaFacturacion;
import facturador.SolicitudPagoFactura;
import crm.SistemaCRM;
import correo.SistemaCorreo;
import utilidades.DatosBDSimulada;
import utilidades.Cliente;


/**
 *
 * @author Fabrizio Bolaño
 */
public class FachadaPagoLinea implements InterfaceFacadePago {

    private static final SistemaCRM crmSistema = new SistemaCRM();
    private static final SistemaFacturacion facturaSistema = new SistemaFacturacion();
    private static final SistemaBancario financieraSistema = new SistemaBancario();
    private static final SistemaCorreo correoSistema = new SistemaCorreo();

    @Override
    public RespuestaPago pago(SolicitudPago request)
            throws ErrorGeneralPago {
        Cliente customer = crmSistema.BuscarCliente(request.getClienteId());
        //Validate Set
        if(customer==null){
            throw new ErrorGeneralPago("Id de Cliente no existe '"
                    +request.getClienteId()+"' no existe.");
        }else if("Inactive".equals(customer.getEstado() )){
            throw new ErrorGeneralPago("Id de Cliente no existe '"
                    +request.getClienteId()+"' esta inactivo.");
        }else if(request.getMonto() >
                facturaSistema.ConsultaSaldoCliente(customer.getId())){
            throw new ErrorGeneralPago("Estas tratando de hacer un pago "
                    + "\n\tmayor que el saldo del cliente");
        }

        //Cargo a la tarjeta
        SolicitudTransferencia transfer = new SolicitudTransferencia(
                request.getMonto() ,request.getNumeroTarjeta(),
                request.getNombreTarjeta(), request.getFechaExpiracionTarjeta() ,
                request.getNumeroTarjeta());
        String payReference = financieraSistema.Transferencia(transfer);

        //Impacto de la transacción
        SolicitudPagoFactura solicitudPago = new SolicitudPagoFactura(
                request.getClienteId(), request.getMonto());
        double newBalance =  facturaSistema.pago(solicitudPago);

        //El cliente se reactiva si el nuevo saldo es inferior a 51 dólares
        String newStatus = customer.getEstado();
        if(newBalance<=50){
            DatosBDSimulada.CambiarEstadoCliente(request.getClienteId(), "Activo");
            newStatus = "Activo";
        }

        //Envio de la confirmación de pago por Email.
        HashMap<String,String> params = new HashMap<>();
        params.put("$nombre", customer.getNombre());
        params.put("$Monto", request.getMonto()+"");
        params.put("$NuevoSaldo", newBalance+"");
        String number = request.getNumeroTarjeta();
        String subfix = number.substring(number.length()-4, number.length());
        params.put("$NumeroTarjeta", subfix);
        params.put("$Referencia", payReference);
        params.put("$NuevoEstado", newStatus);
        correoSistema.EnviarCorreo(params);

        return new RespuestaPago(payReference, newBalance, newStatus);

    }


}