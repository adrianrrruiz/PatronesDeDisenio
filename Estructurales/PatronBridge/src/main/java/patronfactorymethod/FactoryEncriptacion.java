package patronfactorymethod;

import encriptacion.InterfaceEncriptar;
import utilidades.UtilidadesAcceso;

import java.util.Properties;

public class FactoryEncriptacion {

    private static final String FACTORY_PROPERTY_URL = "Propiedades/configuracion.properties";
    private static final String DEFAULT_ENCRIPTACION_CLASS_PROP = "defaultEncriptacionClass";

    public static InterfaceEncriptar getDefaultEncriptacionAdapter() {
        try {
            Properties prop = UtilidadesAcceso.loadProperty(FACTORY_PROPERTY_URL);
            String defaultEncriptacionClass = prop.getProperty(DEFAULT_ENCRIPTACION_CLASS_PROP);
            System.out.println("DefaultEncriptacionClass ==> " + defaultEncriptacionClass);
            return (InterfaceEncriptar) Class.forName(defaultEncriptacionClass).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}