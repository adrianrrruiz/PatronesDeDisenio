// src/state/energy/SavingEnergyState.java
package state.energy;

import device.Device;
import state.EnergyState;

public class SavingEnergyState implements EnergyState {
    private Device device;

    @Override
    public void setDevice(Device device) {
        this.device = device;
    }

    @Override
    public void lowBatteryAlert() {
        int batteryPercentage = device.getBatteryPercentage();
        if (batteryPercentage < 15) {
            System.out.println("Low battery");
        } else {
            System.out.println("(No energy alert)");
        }
    }
}