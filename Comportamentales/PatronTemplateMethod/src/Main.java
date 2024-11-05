import templateMethod.CasaAbstracta;
import templateMethod.CasaEstandar;
import templateMethod.CasaPersonalizada;
import templateMethod.Rascacielos;

public class Main {
    public static void main(String[] args) {
        System.out.println("Construcción de casa estándar:");
        CasaAbstracta casaEstandar = new CasaEstandar();
        casaEstandar.construirCasa();

        System.out.println("Construcción de casa personalizada:");
        CasaAbstracta casaPersonalizada = new CasaPersonalizada();
        casaPersonalizada.construirCasa();

        System.out.println("Construcción de rascacielos:");
        CasaAbstracta rascacielos = new Rascacielos();
        rascacielos.construirCasa();
    }
}
