package templateMethod;

public class CasaPersonalizada extends CasaAbstracta {

    @Override
    protected void construirCimientos() {
        System.out.println("Construyendo cimientos reforzados.");
    }

    @Override
    protected void construirEstructura() {
        System.out.println("Construyendo estructura de acero.");
    }

    @Override
    protected void instalarPuertas() {
        System.out.println("Instalando puertas de diseño personalizado.");
    }

    @Override
    protected void instalarVentanas() {
        System.out.println("Instalando ventanas de alta eficiencia energética.");
    }

    @Override
    protected void pintarCasa() {
        System.out.println("Pintando casa de color azul.");
    }

    // Sobrescribimos el hook para indicar que esta casa no tiene garage
    @Override
    protected boolean tieneGarage() {
        return false; // No se construirá un garage
    }
}
