package io.github.newlight77.kata;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BowlingGame {
    public List<Frame> convert(String bowlingGame) {
        List<String> framesAsString = Arrays.asList(bowlingGame.split(","));
        return framesAsString.stream().map( frame -> {
            return new Frame(frame.substring(0, 1), frame.substring(1, 2));
        }).collect(Collectors.toList());
    }

    public int score(List<Frame> frames) {
        return 0;
    }
}
