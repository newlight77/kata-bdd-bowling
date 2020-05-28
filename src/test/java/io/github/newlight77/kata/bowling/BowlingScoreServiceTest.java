package io.github.newlight77.kata.bowling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BowlingScoreServiceTest {

    @Test
    public void should_get_score_0_when_having_missing_frames() {
        // arrange
        Frame frame1 = new Frame("-", "-");
        Frame frame2 = new Frame("-", "-");
        Frame frame3 = new Frame("-", "-");
        List<Frame> frames = new ArrayList<>();
        frames.add(frame1);
        frames.add(frame2);
        frames.add(frame3);

        // act
        int score = new BowlingScoreService().score(frames);

        // assert
        Assertions.assertEquals(0, score);
    }

    @Test
    public void should_get_score_9_when_having_few_valid_frames() {
        // arrange
        Frame frame1 = new Frame("3", "-");
        Frame frame2 = new Frame("2", "1");
        Frame frame3 = new Frame("1", "2");
        List<Frame> frames = new ArrayList<>();
        frames.add(frame1);
        frames.add(frame2);
        frames.add(frame3);

        // act
        int score = new BowlingScoreService().score(frames);

        // assert
        Assertions.assertEquals(0, score);
    }
}
