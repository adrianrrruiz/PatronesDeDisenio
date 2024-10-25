// src/state/EnergyState.java
package state;

import device.Device;

public interface EnergyState {
    void setDevice(Device device);
    void lowBatteryAlert();
}