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
}
