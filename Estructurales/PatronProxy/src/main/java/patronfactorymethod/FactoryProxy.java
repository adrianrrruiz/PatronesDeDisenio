package patronfactorymethod;

import implementacion.InterfaceProcesos;
import utilidades.UtilidadesAcceso;

import java.util.Properties;

public class FactoryProxy {

    private static final String FACTORY_PROPERTY_URL = "Propiedades/configuracion.properties";
    private static final String DEFAULT_PROXY_CLASS_PROP = "defaultProxyClass";

    public static InterfaceProcesos getDefaultProxyAdapter() {
        try {
            Properties prop = UtilidadesAcceso.loadProperty(FACTORY_PROPERTY_URL);
            String defaultProxyClass = prop.getProperty(DEFAULT_PROXY_CLASS_PROP);
            System.out.println("DefaultEncriptacionClass ==> " + defaultProxyClass);
            return (InterfaceProcesos ) Class.forName(defaultProxyClass).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}