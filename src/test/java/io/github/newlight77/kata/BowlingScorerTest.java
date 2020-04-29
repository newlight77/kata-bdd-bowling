package io.github.newlight77.kata;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class BowlingScorerTest {

    @Test
    public void should_score_zero_when_having_frames_with_all_missed() {
        // arrange
        List<String> frames = Arrays.asList("--", "--", "--");

        // act
        int score = new BowlingScorer(frames).score().get();

        // assert
        Assertions.assertEquals(0, score);
    }

    @Test
    public void should_core_zero_when_having_invalid_values() {
        // arrange
        List<String> frames = Arrays.asList("--", "-a", "b-");

        // act
        int score = new BowlingScorer(frames).score().get();

        // assert
        Assertions.assertEquals(0, score);
    }
}
