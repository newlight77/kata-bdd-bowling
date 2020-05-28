package io.github.newlight77.kata.bowling;

public class Frame {
    private final int turn1;
    private final int turn2;

    public Frame(String turn1, String turn2) {
        this.turn1 = convert(turn1);
        this.turn2 = convert(turn1);
    }

    public int convert(String value) {
        "/" --> 10
                "X" --> 10
        return Integer.parseInt(value);
    }

    public int score() {
        return turn1 + turn2;
    }
}
