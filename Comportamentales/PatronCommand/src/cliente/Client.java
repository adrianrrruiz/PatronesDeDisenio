/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Comportamiento - > Command
 * Tipo de Clase: Cliente
 */
package cliente;

import comandos.Command;
import comandos.LightOffCommand;
import comandos.LightOnCommand;
import comandos.RevertCommand;
import invocadores.RemoteControl;
import receptores.Light;

/**
 * Clase principal que ejecuta el patrón Command
 */
public class Client {
    public static void main(String[] args) {
        // Receptor
        Light light = new Light();

        // Command
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command revert = new RevertCommand(light);

        // Invocador
        RemoteControl remote = new RemoteControl();
        remote.setCommand(lightOn);
        remote.pressButton(); // Output: Light is on
        remote.setCommand(lightOff);
        remote.pressButton(); // Output: Light is off
        remote.setCommand(revert);
        remote.pressButton(); // Output: Light is on
        remote.setCommand(lightOff);
        remote.pressButton(); // Output: Light is off
        remote.setCommand(revert);
        remote.pressButton(); // Output: Light is on
    }
}