package io.github.newlight77.kata;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BowlingScorer {
    private final LinkedList<Frame> frames;

    public BowlingScorer(List<String> frameList) {
        frames = frameList.stream()
                .map(Frame::new).collect(Collectors.toCollection(LinkedList::new));
    }

    public Optional<Integer> score() {
        return frames.stream()
                .map(Frame::score)
                .reduce(Integer::sum);
    }

    static class Frame {
        int first;
        int second;

        public Frame(String frame) {
            String values = frame.replaceAll("-", "0");
            first = Integer.parseInt(values.substring(0,1));
            second = Integer.parseInt(values.substring(1,2));
        }

        public static int score(Frame frame) {
            return frame.first + frame.second;
        }
    }

}
