package device;
// src/Device.java
import state.SoundState;
import state.energy.SavingEnergyState;
import state.sound.NormalState;
import state.EnergyState;
import state.energy.NormalEnergyState;

public class Device {
    private SoundState soundState;
    private EnergyState energyState;
    private int batteryPercentage;
    private int brightnessPercentage;

    public Device() {
        this.soundState = new NormalState();
        this.energyState = new NormalEnergyState();
        this.energyState.setDevice(this);
        this.batteryPercentage = 100; // Default battery percentage
        this.brightnessPercentage = 100; // Default brightness percentage
    }

    public void setSoundState(SoundState state) {
        this.soundState = state;
    }

    public void setEnergyState(EnergyState state) {
        this.energyState = state;
        this.energyState.setDevice(this);
    }

    public void setBatteryPercentage(int batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }

    public void setMaxBrightness(){
        if (this.energyState instanceof SavingEnergyState) {
            this.brightnessPercentage = 65;
        } else {
            this.brightnessPercentage = 100;
        }
    }

    public int getBatteryPercentage() {
        return this.batteryPercentage;
    }

    public int getBrightnessPercentage() {
        return this.brightnessPercentage;
    }

    public void alertSound() {
        this.soundState.alert();
    }

    public void alertEnergy() {
        this.energyState.lowBatteryAlert();
    }
}