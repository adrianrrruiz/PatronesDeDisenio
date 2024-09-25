/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Adapter
 * Tipo de Clase: Main()
 */
package patronadapter;
import implementacion.*;

/**
 *
 * @author Fabrizio Bolaño
 */
public class PatronAdapterMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        FintechSolicitudCredito request = new FintechSolicitudCredito();
        request.setCliente("Cristiano Ronaldo");
        request.setValor(1600);

        InterfaceFintechAdaptador FinancieraB = new AdaptadorFitechB();
        FintechCreditoRespuesta FBresponse = FinancieraB.EnvioSolicitudCredito(request);
        System.out.println("Resultado aprobación Financiera <<B>>: > " + FBresponse.isAprobacion() + "\n");

        if (FBresponse.isAprobacion()) {
            System.out.println("Felicitaciones!!!!!, la Financiera <<B>> aprobó su solicitud de crédito." + "\n");
        }
        else
        {
            System.out.println("Lo sentimos, la Financiera <<B>> no aprobó su crédito");
        }

        System.out.println("---------------------------");

        InterfaceFintechAdaptador FinancieraA = new AdaptadorFintechA();
        FintechCreditoRespuesta FAresponse = FinancieraA.EnvioSolicitudCredito(request);
        System.out.println("Resultado aprobación Financiera <<A>>: > " + FAresponse.isAprobacion() + "\n");

        if (FAresponse.isAprobacion()) {
            System.out.println("Felicitaciones!!!!!, la Financiera <<A>> aprobó su solicitud de crédito.");
        }
        else
        {
            System.out.println("Lo sentimos, la Financiera <<A>> no aprobó su crédito");
        }

        System.out.println("---------------------------");

        InterfaceFintechAdaptador FinancieraC = new AdaptadorFintechC();
        FintechCreditoRespuesta FCresponse = FinancieraC.EnvioSolicitudCredito(request);
        System.out.println("Resultado aprobación Financiera <<C>>: > " + FCresponse.isAprobacion() + "\n");

        if (FCresponse.isAprobacion()) {
            System.out.println("Felicitaciones!!!!!, la Financiera <<C>> aprobó su solicitud de crédito." + "\n");
        }
        else
        {
            System.out.println("Lo sentimos, la Financiera <<C>> no aprobó su crédito");
        }

    }

}