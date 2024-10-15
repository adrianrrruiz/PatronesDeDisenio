/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Facade
 * Tipo de Clase: Java
 */

package utilidades;

/**
 *
 * @author Fabrizio Bolaño
 */
public class Cliente {
    private Long id;
    private String nombre;
    private double balance;
    private String estado;
    private int puntos;

    public Cliente() {
    }

    public Cliente(Long id, String nombre, double balance, String estado, int puntos) {
        this.id = id;
        this.nombre = nombre;
        this.balance = balance;
        this.estado = estado;
        this.puntos = puntos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", "
                + "\nbalance=" + balance + ", estado=" + estado + ", puntos=" + puntos + '}';
    }


}