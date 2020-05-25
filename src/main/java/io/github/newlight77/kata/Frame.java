package io.github.newlight77.kata;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Frame {
    private String turn1 = "";
    private String turn2 = "";

    public Frame(String turn1, String turn2) {
        this.turn1 = turn1;
        this.turn2 = turn2;
    }

    public String getTurn1() {
        return turn1;
    }

    public void setTurn1(String turn1) {
        this.turn1 = turn1;
    }

    public String getTurn2() {
        return turn2;
    }

    public void setTurn2(String turn2) {
        this.turn2 = turn2;
    }

    private List<Frame> convert(String bowlingGame) {
        List<String> framesAsString = Arrays.asList(bowlingGame.split(","));
        return framesAsString.stream().map( frame -> {
            return new Frame(frame.substring(0, 1), frame.substring(1, 2));
        }).collect(Collectors.toList());
    }
}

