package implementacion;

import java.util.HashMap;
import java.util.Map;

public class FabricaArtistas {
    private static final Map<String, Artista> ARTISTAS = new HashMap<>();
    private static Long secuencia = 0L;

    public static Artista obtenerArtista(String nombreArtista) {
        if (ARTISTAS.containsKey(nombreArtista)) {
            return ARTISTAS.get(nombreArtista);
        } else {
            Artista artista = new Artista(++secuencia, nombreArtista);
            ARTISTAS.put(nombreArtista, artista);
            return artista;
        }
    }
}
