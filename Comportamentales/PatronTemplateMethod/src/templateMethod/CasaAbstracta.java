package templateMethod;

public abstract class CasaAbstracta {
    // Método plantilla que define el esqueleto de la construcción
    public final void construirCasa() {
        construirCimientos();
        construirEstructura();
        instalarPuertas();
        instalarVentanas();
        if (tieneGarage()) { // Hook o gancho
            construirGarage();
        }
        pintarCasa();
        System.out.println("Casa construida.\n");
    }

    // Pasos comunes que las subclases pueden sobrescribir
    protected abstract void construirCimientos();
    protected abstract void construirEstructura();
    protected abstract void instalarPuertas();
    protected abstract void instalarVentanas();
    protected abstract void pintarCasa();

    // Método opcional (hook) que se puede sobrescribir
    protected boolean tieneGarage() {
        return true; // Valor por defecto
    }

    // Método adicional solo si hay un garage
    protected void construirGarage() {
        System.out.println("Construyendo un garage.");
    }
}