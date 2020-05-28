package io.github.newlight77.kata.bowling;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BowlingScoreService {
    public int score(List<Frame> frames) {
        int score  = frames.stream().reduce((turn1, turn2) -> turn1 + turn2).get();
        return score;
    }

}
