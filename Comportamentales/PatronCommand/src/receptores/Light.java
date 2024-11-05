/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Comportamiento - > Command
 * Tipo de Clase: Receptor
 */
package receptores;

/**
 * Receptor que realiza la acción
 */
public class Light {

    public boolean isOn = false;

    public void turnOn() {
        System.out.println("Light is on");
        isOn = true;
    }

    public void turnOff() {
        System.out.println("Light is off");
        isOn = false;
    }

    public void revert() {
        System.out.println("Light is reverting");
        if(isOn){
            turnOff();
        } else {
            turnOn();
        }
    }
}