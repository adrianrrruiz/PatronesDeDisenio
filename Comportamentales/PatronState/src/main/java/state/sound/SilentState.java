package state.sound;

import state.SoundState;

public class SilentState implements SoundState {
    @Override
    public void alert() {
        System.out.println("(No sound)");
    }
}