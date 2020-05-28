package io.github.newlight77.kata.bowling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/score")
public class BowlingScorerController {

    @Autowired
    private BowlingScoreService bowlingScoreService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public int score(@RequestBody String framesAsString) {

        List<Frame> frames = Arrays.asList(framesAsString.split(",")).stream().map(f -> {
            String turn1 = f.substring(0,1);
            String turn2 = f.substring(1,2);
            return new Frame(turn1, turn2);
        }).collect(Collectors.toList());

        return bowlingScoreService.score(frames);
    }
}
