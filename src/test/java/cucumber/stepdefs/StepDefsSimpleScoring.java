package cucumber.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.newlight77.kata.BowlingScorer;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class StepDefsSimpleScoring {

    private List<String> frameList;
    private int score;

    @Given("a game with knocked pins represented with {string}")
    public void a_game_with_knocked_pins_represented_with(String frames) {
        frameList = Arrays.asList(frames.split(","));
    }

    @When("the score is calculated")
    public void the_score_is_calculated() {
        score = new BowlingScorer(frameList).score();
    }

    @Then("the score is {int}")
    public void the_score_is(Integer finalScore) {

        Assertions.assertEquals(finalScore, this.score);
    }

}
