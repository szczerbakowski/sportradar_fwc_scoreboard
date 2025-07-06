package com.sportradar.fwc.scoreboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
