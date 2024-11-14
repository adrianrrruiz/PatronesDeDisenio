/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Bridge
 * Tipo de Clase: Main()
 */

package patronbridge;
import encriptacion.ProcesoEncriptarAES;
import encriptacion.ProcesoEncriptarBlowfish;
import encriptacion.ProcesoEncriptarDES;
import encriptacion.ProcesoSinEncriptar;
import implementacion.PuenteMensajeEncriptacion;
import implementacion.InterfaceMensajeEncriptacion;
import patronfactorymethod.FactoryEncriptacion;


public class PatronBridgeMain {

    public static void main(String[] args) {

//        ========== ANTES ==========
//        InterfaceMensajeEncriptacion FormatoAES = new PuenteMensajeEncriptacion(new ProcesoEncriptarAES());
//        InterfaceMensajeEncriptacion FormatoDES = new PuenteMensajeEncriptacion(new ProcesoEncriptarDES());
//        InterfaceMensajeEncriptacion FormatoBlowfish = new PuenteMensajeEncriptacion(new ProcesoEncriptarBlowfish());
//        InterfaceMensajeEncriptacion SinFormato = new PuenteMensajeEncriptacion(new ProcesoSinEncriptar());
//
//        try {
//            final String message = "<Curso><Nombre>Patrones de Diseño de Software</Nombre></Curso>";
//            String messageAES = FormatoAES.EncryptarMensaje(message, "HG58YZ3CR9123456");
//            System.out.println("Formato AES > " + messageAES + "\n");
//
//            String messageDES = FormatoDES.EncryptarMensaje(message, "XMzDdG4D03CKm2Ix");
//            System.out.println("Formato DES > " + messageDES + "\n");
//
//            String messageBlowfish = FormatoBlowfish.EncryptarMensaje(message, "PatronBridgeReto123");
//            System.out.println("Formato Blowfish > " + messageBlowfish + "\n");
//
//            String messageNO = SinFormato.EncryptarMensaje(message, null);
//            System.out.println("Sin Formato > " + messageNO + "\n");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        ==================================================

//         ========== DESPUÉS (Con patrón Factory)==========
        InterfaceMensajeEncriptacion Formato = new PuenteMensajeEncriptacion(FactoryEncriptacion.getDefaultEncriptacionAdapter());
        try {
            final String message = "<Curso><Nombre>Patrones de Diseño de Software</Nombre></Curso>";
            String messageEncriptado = Formato.EncryptarMensaje(message, "HG58YZ3CR9123456");
            System.out.println("Formato desde archivo configuración > " + messageEncriptado + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
//        ==================================================



    }

}
