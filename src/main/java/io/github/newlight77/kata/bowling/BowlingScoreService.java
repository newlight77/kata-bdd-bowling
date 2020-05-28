package io.github.newlight77.kata.bowling;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BowlingScoreService {
    public int score(List<Frame> frames) {
        int score  = frames.stream().map(frame -> {
            int turn1 = 0;
            int turn2 = 0;
            if (!"-".equals(frame.getTurn1())) {
                turn1 = Integer.parseInt(frame.getTurn1());
            }
            if (!"-".equals(frame.getTurn2())) {
                turn2 = Integer.parseInt(frame.getTurn2());
            }
            return turn1 + turn2 ;
        }).reduce((turn1, turn2) -> turn1 + turn2).get();

        return score;
    }
}
