// src/App.java
import state.energy.NormalEnergyState;
import state.sound.SilentState;
import state.sound.VibrationState;
import state.sound.NormalState;
import device.Device;
import state.energy.SavingEnergyState;

public class App {
    public static void main(String[] args) {
        Device device = new Device();

        System.out.println("Normal sound mode:");
        device.alertSound();

        System.out.println("\nSwitching to Silent mode:");
        device.setSoundState(new SilentState());
        device.alertSound();

        System.out.println("\nSwitching to Vibration mode:");
        device.setSoundState(new VibrationState());
        device.alertSound();

        System.out.println("---------------------------------");

        device.alertEnergy();
        System.out.println("\nSetting battery percentage to 20:");
        device.setBatteryPercentage(20);
        device.alertEnergy();

        System.out.println("\nSwitching to Saving Energy mode:");
        device.setEnergyState(new NormalEnergyState());
        device.alertEnergy();

        System.out.println("\nSetting battery percentage to 10:");
        device.setBatteryPercentage(10);
        device.alertEnergy();

        System.out.println("---------------------------------");
        System.out.println("\nSetting max brightness:");
        device.setMaxBrightness();
        System.out.println("Brightness percentage: " + device.getBrightnessPercentage());

    }
}