package decoradores;

import mensajes.InterfaceMensaje;

public class CredencialesDecorador extends DecoradorMensaje {

    private String usuario;
    private String password;

    public CredencialesDecorador(InterfaceMensaje Formatomensaje, String usuario, String password) {
        super(Formatomensaje);
        this.usuario = usuario;
        this.password = password;
    }

    @Override
    public InterfaceMensaje ProcesarMensaje() {
        Formatomensaje = Formatomensaje.ProcesarMensaje();
        Formatomensaje = agregarCredenciales();
        return Formatomensaje;
    }

    private InterfaceMensaje agregarCredenciales() {
        String headerCredenciales = "<soapenv:Header>\n"
                + "   <auth>\n"
                + "      <usuario>" + usuario + "</usuario>\n"
                + "      <password>" + password + "</password>\n"
                + "   </auth>\n"
                + "</soapenv:Header>\n";
        String nuevoContenido = headerCredenciales + Formatomensaje.getContenido();
        Formatomensaje.setContenido(nuevoContenido);
        return Formatomensaje;
    }
}
