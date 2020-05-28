package io.github.newlight77.kata.bowling;

public class Frame {
    private final String turn1;
    private final String turn2;

    public Frame(String turn1, String turn2) {
        this.turn1 = turn1;
        this.turn2 = turn2;
    }

    public String getTurn1() {
        return turn1;
    }

    public String getTurn2() {
        return turn2;
    }
}
