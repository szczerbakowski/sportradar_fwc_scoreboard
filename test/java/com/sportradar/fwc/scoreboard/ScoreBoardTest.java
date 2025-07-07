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

    @Test
    public void shouldReturnMatchesOrderedByTotalScore() {
        ScoreBoard scoreBoard = new ScoreBoard();

        Match match1 = scoreBoard.startMatch("Spain", "Germany");
        Match match2 = scoreBoard.startMatch("France", "Italy");
        Match match3 = scoreBoard.startMatch("Brazil", "Argentina");

        match1.updateScore(1, 2);
        match2.updateScore(0, 1);
        match3.updateScore(3, 2);

        assertEquals(match3, scoreBoard.getSummary().get(0));
        assertEquals(match1, scoreBoard.getSummary().get(1));
        assertEquals(match2, scoreBoard.getSummary().get(2));
    }

    @Test
    public void shouldReturnMatchesOrderedByTotalScoreAndStartTime() {
        ScoreBoard scoreBoard = new ScoreBoard();

        Match match1 = scoreBoard.startMatch("Spain", "Germany");
        Match match2 = scoreBoard.startMatch("France", "Italy");
        Match match3 = scoreBoard.startMatch("Brazil", "Argentina");

        match1.updateScore(1, 2);
        match2.updateScore(2, 1);
        match3.updateScore(3, 2);

        assertEquals(match3, scoreBoard.getSummary().get(0));
        assertEquals(match1, scoreBoard.getSummary().get(1));
        assertEquals(match2, scoreBoard.getSummary().get(2));
    }


}