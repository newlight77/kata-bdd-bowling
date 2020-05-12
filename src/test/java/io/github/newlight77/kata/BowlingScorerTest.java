package io.github.newlight77.kata;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class BowlingScorerTest {

    @Test
    public void should_score_zero_when_having_frames_no_values() {
        // arrange
        List<String> frames = Arrays.asList();

        // act
        int score = new BowlingScorer(frames).score();

        // assert
        Assertions.assertEquals(0, score);
    }

    @Test
    public void should_score_zero_when_having_frames_with_all_missed() {
        // arrange
        List<String> frames = Arrays.asList("--", "--", "--");

        // act
        int score = new BowlingScorer(frames).score();

        // assert
        Assertions.assertEquals(0, score);
    }

    @Test
    public void should_core_zero_when_having_invalid_values() {
        // arrange
        List<String> frames = Arrays.asList("--", "-a", "b-");

        // act
        int score = new BowlingScorer(frames).score();

        // assert
        Assertions.assertEquals(0, score);
    }

    @Test
    public void should_core_19_when_having_values() {
        // arrange
        List<String> frames = Arrays.asList("12", "-7", "72");

        // act
        int score = new BowlingScorer(frames).score();

        // assert
        Assertions.assertEquals(19, score);
    }

    @Test
    public void should_core_28_when_having_spares() {
        // arrange
        List<String> frames = Arrays.asList("1/", "-/", "31");

        // act
        int score = new BowlingScorer(frames).score();

        // assert
        Assertions.assertEquals(28, score);
    }

    @Test
    public void should_core_19_when_having_single_strike() {
        // arrange
        List<String> frames = Arrays.asList("X", "22", "-1");

        // act
        int score = new BowlingScorer(frames).score();

        // assert
        Assertions.assertEquals(19, score);
    }

    @Test
    public void should_core_28_when_having_double_strikes() {
        // arrange
        List<String> frames = Arrays.asList("X", "X", "12");

        // act
        int score = new BowlingScorer(frames).score();

        // assert
        Assertions.assertEquals(37, score);
    }

    @Test
    public void should_core_28_when_having_triple_strikes() {
        // arrange
        List<String> frames = Arrays.asList("X", "X", "X", "11");

        // act
        int score = new BowlingScorer(frames).score();

        // assert
        Assertions.assertEquals(19, score);
    }

    @Test
    public void should_core_300_when_having_only_strikes() {
        // arrange
        List<String> frames = Arrays.asList("X", "X", "X", "XXX");

        // act
        int score = new BowlingScorer(frames).score();

        // assert
        Assertions.assertEquals(120, score);
    }
}
