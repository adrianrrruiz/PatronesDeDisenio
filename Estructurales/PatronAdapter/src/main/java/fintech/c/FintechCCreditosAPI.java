package fintech.c;

import fintech.a.FintechACreditos;
import fintech.a.FintechAResultadoAprobacion;
import fintech.a.IntFintechARecepcionCredito;

public class FintechCCreditosAPI {

    public void sendCreditForValidate(final FintechCSolicitudCredito request, final IntFintechCRecepcionCredito listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("La Fintech C ha recibido su solicitud, dentro de poco recibirá una respuesta");
                FintechCRespuestaCredito response = new FintechCRespuestaCredito();
                if (request.getValorSolicitado() <= 2000) {
                    response.setAprobado("Y");
                } else {
                    response.setAprobado("N");
                }
                try {
                    Thread.sleep(1000 * 10);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                listener.NotificacionResultado(response);
            }
        }).start();
    }

}
