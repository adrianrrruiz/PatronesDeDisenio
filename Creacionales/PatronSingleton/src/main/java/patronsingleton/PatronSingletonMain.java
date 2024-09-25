/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Creacional - > Singleton
 * Tipo de Clase: Main()
 */
package patronsingleton;
/**
 *
 * @author Fabrizio Bolaño
 */
public class PatronSingletonMain {
    public static void main(String[] args) {
        //Configuración de Propiedades para el Modulo No->1
        ParametrizacionSingleton singletonA = ParametrizacionSingleton.getInstance();
        //Configuración de Propiedades para el Modulo No->1
        ParametrizacionSingleton singletonB = ParametrizacionSingleton.getInstance();
        System.out.println(singletonA);
        System.out.println(singletonB);
        System.out.println("Igual referencia ==> " + (singletonA == singletonB));
        singletonA.setNombreAplicacion("Patron Creacional Singleton");
        singletonB.setNumeroVersion("2.0x");
        System.out.println("SingletonA ==> " + singletonA);
        System.out.println("SingletonB ==> " + singletonB);
        singletonA = null;
        singletonB = null;
        singletonA = ParametrizacionSingleton.getInstance();
        System.out.println("singletonA ==> " + singletonA);

        System.out.println("");
        System.out.println("Ejercicio hilos:");
        // Crear tres hilos que modificarán el Singleton
        Thread thread1 = new Thread(new SingletonModifier("App1", "1.0"));
        Thread thread2 = new Thread(new SingletonModifier("App2", "2.0"));
        Thread thread3 = new Thread(new SingletonModifier("App3", "3.0"));

        // Iniciar los hilos
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            // Esperar a que todos los hilos terminen
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Obtener la instancia del singleton y verificar el estado final de sus atributos
        ParametrizacionSingleton singletonFinal = ParametrizacionSingleton.getInstance();
        System.out.println("Estado final del Singleton:");
        System.out.println(singletonFinal);
    }

}

class SingletonModifier implements Runnable {
    private String nombreAplicacion;
    private String numeroVersion;

    public SingletonModifier(String nombreAplicacion, String numeroVersion) {
        this.nombreAplicacion = nombreAplicacion;
        this.numeroVersion = numeroVersion;
    }

    @Override
    public void run() {
        // Obtener referencia al Singleton
        ParametrizacionSingleton singleton = ParametrizacionSingleton.getInstance();

        // Modificar atributos
        singleton.setNombreAplicacion(nombreAplicacion);
        singleton.setNumeroVersion(numeroVersion);

        System.out.println("Hilo " + Thread.currentThread().getName() + " modificó el Singleton: " + singleton);
    }
}