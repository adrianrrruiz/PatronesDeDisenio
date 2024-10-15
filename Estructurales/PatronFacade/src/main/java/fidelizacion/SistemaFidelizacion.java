package fidelizacion;

import utilidades.Cliente;

public class SistemaFidelizacion {

    public int calcularPuntos(double monto) {
        return (int) (monto / 100) * 10;
    }

    public boolean validarPagoConPuntos(Cliente cliente, double monto) {
        double puntosNecesarios = monto * 10;
        return cliente.getPuntos() >= puntosNecesarios;
    }

    public void aplicarPagoConPuntos(Cliente cliente, double monto) {
        double puntosNecesarios = monto * 10;
        cliente.setPuntos((int) (cliente.getPuntos() - puntosNecesarios));
    }
}
