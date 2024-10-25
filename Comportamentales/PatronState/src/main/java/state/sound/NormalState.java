package state.sound;

import state.SoundState;

public class NormalState implements SoundState {
    @Override
    public void alert() {
        System.out.println("Ringing...");
    }
}