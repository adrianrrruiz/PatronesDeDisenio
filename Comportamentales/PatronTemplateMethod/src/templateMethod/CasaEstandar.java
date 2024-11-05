package templateMethod;

public class CasaEstandar extends CasaAbstracta {

    @Override
    protected void construirCimientos() {
        System.out.println("Construyendo cimientos de concreto.");
    }

    @Override
    protected void construirEstructura() {
        System.out.println("Construyendo estructura de madera.");
    }

    @Override
    protected void instalarPuertas() {
        System.out.println("Instalando puertas estándar.");
    }

    @Override
    protected void instalarVentanas() {
        System.out.println("Instalando ventanas estándar.");
    }

    @Override
    protected void pintarCasa() {
        System.out.println("Pintando casa de color blanco.");
    }
}