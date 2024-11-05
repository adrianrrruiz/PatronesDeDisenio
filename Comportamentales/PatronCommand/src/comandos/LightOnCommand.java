/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Comportamiento - > Command
 * Tipo de Clase: Command Concreto
 */
package comandos;

import receptores.Light;

/**
 * Comando concreto para encender la luz
 */
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}
