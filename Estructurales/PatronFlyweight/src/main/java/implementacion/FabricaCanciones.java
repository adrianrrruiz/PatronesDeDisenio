/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Flyweight
 * Tipo de Clase: Java
 */
package implementacion;

import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Fabrizio Bolaño
 */
public class FabricaCanciones {

    public static boolean HabilitarFlyweight = true;
    private static final Map<String,Cancion> PLAY_CANCION = new HashMap<>();
    private static Long Secuencia = 0L;

    public static Cancion CrearItem(String NombreTema, String nombreArtista){
        if(HabilitarFlyweight && PLAY_CANCION.containsKey(NombreTema)){
            return PLAY_CANCION.get(NombreTema);
        }else{
            Artista artista = FabricaArtistas.obtenerArtista(nombreArtista);  // Obtener el artista
            Cancion playItem = new Cancion(++Secuencia, NombreTema, artista);
            PLAY_CANCION.put(NombreTema, playItem);
            return playItem;
        }
    }
}