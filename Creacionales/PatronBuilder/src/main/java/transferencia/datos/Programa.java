package transferencia.datos;

public class Programa {
    private String nombre;
    private String codigo;
    private String creditos;
    private String semestre;

    public Programa() {
    }

    public Programa(String nombre, String codigo, String creditos, String semestre) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        this.semestre = semestre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCreditos() {
        return creditos;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return "{" + "\n\tNombre: " + nombre + "\n\tCodigo: " + codigo + "\n\tCreditos: " + creditos + "\n\tSemestre: " + semestre + "\n}";
    }
}
