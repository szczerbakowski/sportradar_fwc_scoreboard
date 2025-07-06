package com.sportradar.fwc.scoreboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MatchTest {

    @Test
    public void shouldCreateMatchWithHomeAndAwayTeam() {
        String homeTeam = "Spain";
        String awayTeam = "Germany";

        Match match = new Match(homeTeam, awayTeam);

        assertEquals(homeTeam, match.getHomeTeam());
        assertEquals(awayTeam, match.getAwayTeam());
    }

    @Test
    public void shouldCreateMatchWithScoreZeroZero() {
        Match match = new Match("Spain", "Germany");

        assertEquals(0, match.getHomeTeamScore());
        assertEquals(0, match.getAwayTeamScore());
    }

    @Test
    public void shouldUpdateScore() {
        Match match = new Match("Spain", "Germany");

        match.updateScore(1, 2);

        assertEquals(1, match.getHomeTeamScore());
        assertEquals(2, match.getAwayTeamScore());
    }

    @Test
    public void shouldReturnTotalScore() {
        Match match = new Match("Spain", "Germany");

        match.updateScore(1, 2);

        assertEquals(3, match.getTotalScore());
    }

    @Test
    public void shouldThrowExceptionWhenScoreIsNegative() {
        Match match = new Match("Spain", "Germany");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> match.updateScore(-1, 2));
        assertEquals("Score cannot be negative", exception.getMessage());

    }

    @Test
    public void shouldThrowExceptionWhenTeamNameIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Match(null, "Germany"));
        assertThrows(IllegalArgumentException.class, () -> new Match("Spain", null));
        assertThrows(IllegalArgumentException.class, () -> new Match(null, null));

        assertEquals("Home team and away team cannot be null", exception.getMessage());
    }
}
