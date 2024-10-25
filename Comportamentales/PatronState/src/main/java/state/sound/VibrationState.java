package state.sound;

import state.SoundState;

public class VibrationState implements SoundState {
    @Override
    public void alert() {
        System.out.println("Vibrating...");
    }
}