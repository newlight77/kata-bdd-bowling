package io.github.newlight77.kata;

import java.util.LinkedList;
import java.util.List;

public class BowlingScorer2 {
    private final List<Frame> frames;

    public BowlingScorer2(List<String> frameList) {
        frames = new LinkedList<>();
        Frame previousFrame = null;
        for (int i=0; i< frameList.size(); i++) {
            frames.add(new Frame(frameList.get(i)));
            if (previousFrame != null) previousFrame.next = frames.get(i);
            previousFrame = frames.get(i);
        }
    }

    public int score() {
        return frames.stream()
                .map(Frame::score)
                .reduce(Integer::sum)
                .orElse(0);
    }

    static class Frame {
        String first;
        String second;
        Frame next;

        public Frame(String frame) {
            first = frame.substring(0,1);
            if (frame.length() > 1) {
                second = frame.substring(1,2);
            }
        }

        public int score() {
            int score = toValue(first);

            if (second != null) {
                score += toValue(second);
            }

            if ("/".equals(second) && next != null ) {
                score += toValue(next.first);
            }

            if ("X".equals(first) && next != null) {
                score += toValue(next.first);
                if (!"X".equals(next.first)) {
                    score += toValue(next.second);
                } else {
                    score += toValue(next.next.first);
                }
            }

            return score;
        }

        private int toValue(String spin) {
            return Integer.parseInt(spin
                    .replaceAll("[a-z|-]", "0")
                    .replace("/", "10")
                    .replace("X", "10"));
        }
    }
}
