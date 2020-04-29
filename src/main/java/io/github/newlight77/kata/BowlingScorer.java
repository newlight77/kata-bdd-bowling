package io.github.newlight77.kata;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BowlingScorer {
    private final LinkedList<Frame> frames;

    public BowlingScorer(List<String> frameList) {
        frames = frameList.stream()
                .map(Frame::new).collect(Collectors.toCollection(LinkedList::new));
    }

    public int score() {
        for (int i=0; i < frames.size(); i++) {
            if (frames.get(i).isSpare) {
                frames.get(i).spareBonus = frames.get(i+1).first;
            }
        }

        return frames.stream()
                .map(Frame::score)
                .reduce(Integer::sum)
                .orElse(0);
    }

    static class Frame {
        int first;
        int second;
        int spareBonus;
        boolean isSpare;

        public Frame(String frame) {
            String values = frame.replaceAll("-", "0");
            first = Integer.parseInt(values.substring(0,1).replace("/", "10"));
            second = Integer.parseInt(values.substring(1,2).replace("/", "10"));
            isSpare = frame.contains("/");
        }

        public int score() {
            return first + second + spareBonus ;
        }
    }
}
