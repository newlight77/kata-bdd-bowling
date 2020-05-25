package cucumber.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.newlight77.kata.BowlingGame;
import io.github.newlight77.kata.Frame;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class BowlingGameStepDefs {
    private List<Frame> frames;
    private BowlingGame bowlingGame = new BowlingGame();
    private int score;

    @Given("a game with knocked pins represented with {string}")
    public void a_game_with_knocked_pins_represented_with(String frames) {
        this.frames = bowlingGame.convert(frames);
    }

    @When("the score is calculated")
    public void the_score_is_calculated() {
        score = bowlingGame.score(frames);
    }

    @Then("the score is {int}")
    public void the_score_is(Integer finalScore) {
        Assertions.assertEquals(finalScore, score);
    }
}
