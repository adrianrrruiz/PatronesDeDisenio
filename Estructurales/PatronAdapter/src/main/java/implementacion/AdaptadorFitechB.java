/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Adapter
 * Tipo de Clase: Java
 */
package implementacion;
import fintech.b.FintechBSolicitudCredito;
import fintech.b.FintechBRespuestaCredito;
import fintech.b.FintechBCreditosAPI;
/**
 *
 * @author Fabrizio Bolaño
 */
public class AdaptadorFitechB implements InterfaceFintechAdaptador {

    @Override
    public FintechCreditoRespuesta EnvioSolicitudCredito(FintechSolicitudCredito request) {
        FintechBSolicitudCredito FBrequest = new FintechBSolicitudCredito();
        FBrequest.setNombreCliente(request.getCliente());
        FBrequest.setValorSolicitado(request.getValor());

        FintechBCreditosAPI api = new FintechBCreditosAPI();
        FintechBRespuestaCredito FBresponse = api.sendCreditRequest(FBrequest);

        FintechCreditoRespuesta response = new FintechCreditoRespuesta();
        response.setAprobacion(FBresponse.isResultadoAprobacion());
        return response;
    }

}