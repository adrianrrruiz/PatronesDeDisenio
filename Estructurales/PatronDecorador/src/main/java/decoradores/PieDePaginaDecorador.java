package decoradores;

import mensajes.InterfaceMensaje;

public class PieDePaginaDecorador extends DecoradorMensaje {

    private String nombreEmpresa;
    private String direccion;
    private String telefono;
    private String correo;

    public PieDePaginaDecorador(InterfaceMensaje Formatomensaje, String nombreEmpresa, String direccion, String telefono, String correo) {
        super(Formatomensaje);
        this.nombreEmpresa = nombreEmpresa;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    @Override
    public InterfaceMensaje ProcesarMensaje() {
        Formatomensaje = Formatomensaje.ProcesarMensaje();
        Formatomensaje = agregarPieDePagina();
        return Formatomensaje;
    }

    private InterfaceMensaje agregarPieDePagina() {
        String pieDePagina = "\n<footer>\n"
                + "   <empresa>" + nombreEmpresa + "</empresa>\n"
                + "   <direccion>" + direccion + "</direccion>\n"
                + "   <telefono>" + telefono + "</telefono>\n"
                + "   <correo>" + correo + "</correo>\n"
                + "</footer>";
        String nuevoContenido = Formatomensaje.getContenido() + pieDePagina;
        Formatomensaje.setContenido(nuevoContenido);
        return Formatomensaje;
    }
}
