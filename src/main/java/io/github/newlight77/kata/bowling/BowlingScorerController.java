package io.github.newlight77.kata.bowling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/score")
public class BowlingScorerController {
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public int score(@RequestBody String frames) {
        return -1;
    }
}
