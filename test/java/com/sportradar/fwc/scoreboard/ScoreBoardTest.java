package com.sportradar.fwc.scoreboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreBoardTest {
    @Test
    public void shouldStartNewMatch() {
        ScoreBoard scoreBoard = new ScoreBoard();

        Match match = scoreBoard.startMatch("Spain", "Germany");

        assertNotNull(match);
        assertEquals(1, scoreBoard.getMatches().size());
    }

    @Test
    public void shouldRemoveMatchFromScoreBoardWhenMatchIsFinished() {
        ScoreBoard scoreBoard = new ScoreBoard();

        Match match = scoreBoard.startMatch("Spain", "Germany");
        scoreBoard.finishMatch(match);

        assertEquals(0, scoreBoard.getMatches().size());
    }


}