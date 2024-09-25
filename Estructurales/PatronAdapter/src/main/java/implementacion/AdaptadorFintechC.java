package implementacion;

import fintech.a.FintechACreditos;
import fintech.a.FintechARecepcionCredito;
import fintech.a.FintechAResultadoAprobacion;
import fintech.c.FintechCCreditosAPI;
import fintech.c.FintechCRespuestaCredito;
import fintech.c.FintechCSolicitudCredito;
import fintech.c.IntFintechCRecepcionCredito;

public class AdaptadorFintechC implements InterfaceFintechAdaptador, IntFintechCRecepcionCredito {
    private FintechCRespuestaCredito FCresponse;

    @Override
    public FintechCreditoRespuesta EnvioSolicitudCredito(FintechSolicitudCredito request) {
        FintechCSolicitudCredito FCrequest = new FintechCSolicitudCredito();
        FCrequest.setValorSolicitado(request.getValor());
        FCrequest.setNombreCliente(request.getCliente());

        FintechCCreditosAPI sender = new FintechCCreditosAPI();
        sender.sendCreditForValidate(FCrequest, this);

        do {
            try {
                Thread.sleep(10000);
                System.out.println("Fintech_C solicitud en espera....");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (FCresponse == null);

        FintechCreditoRespuesta response = new FintechCreditoRespuesta();
        response.setAprobacion(FCresponse.getAprobado() == "Y" ? true : false);
        return response;
    }

    @Override
    public void NotificacionResultado(FintechCRespuestaCredito resultado) {
        this.FCresponse = resultado;
    }
}
