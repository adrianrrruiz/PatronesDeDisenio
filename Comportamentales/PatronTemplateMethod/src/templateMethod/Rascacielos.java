package templateMethod;

public class Rascacielos extends CasaAbstracta {

    @Override
    protected void construirCimientos() {
        System.out.println("Construyendo cimientos de acero reforzado para rascacielos.");
    }

    @Override
    protected void construirEstructura() {
        System.out.println("Construyendo estructura de acero y concreto.");
    }

    @Override
    protected void instalarPuertas() {
        System.out.println("Instalando puertas de seguridad.");
    }

    @Override
    protected void instalarVentanas() {
        System.out.println("Instalando ventanas resistentes a vientos fuertes.");
    }

    @Override
    protected void pintarCasa() {
        System.out.println("Pintando el exterior con materiales resistentes a la intemperie.");
    }

    @Override
    protected boolean tieneGarage() {
        return false; // Los rascacielos suelen tener estacionamientos subterráneos
    }
}
