/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Comportamiento - > Command
 * Tipo de Clase: Invocador
 */
package invocadores;

import comandos.Command;

/**
 * El invocador mantiene un comando y lo ejecuta
 */
public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}