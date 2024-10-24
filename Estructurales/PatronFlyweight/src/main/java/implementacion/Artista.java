package implementacion;

public class Artista {
    private Long id;
    private String nombreArtista;

    public Artista(Long id, String nombreArtista) {
        this.id = id;
        this.nombreArtista = nombreArtista;
    }

    public Long getId() {
        return id;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    @Override
    public String toString() {
        return "Artista{" + "id=" + id + ", nombreArtista='" + nombreArtista + '\'' + '}';
    }
}
