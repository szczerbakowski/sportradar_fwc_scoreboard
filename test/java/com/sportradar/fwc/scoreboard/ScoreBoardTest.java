package com.sportradar.fwc.scoreboard;

import org.junit.jupiter.api.Test;

import java.util.List;

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
    public void shouldReturnMatchesOrderedByTotalScoreAndStartTime() throws InterruptedException {
        ScoreBoard scoreBoard = new ScoreBoard();

        Match match1 = scoreBoard.startMatch("Spain", "Germany");
        Thread.sleep(200);
        Match match2 = scoreBoard.startMatch("France", "Italy");
        Thread.sleep(200);
        Match match3 = scoreBoard.startMatch("Brazil", "Argentina");

        match1.updateScore(1, 2);
        match2.updateScore(2, 1);
        match3.updateScore(3, 2);

        assertEquals(match3, scoreBoard.getSummary().get(0));
        assertEquals(match2, scoreBoard.getSummary().get(1));
        assertEquals(match1, scoreBoard.getSummary().get(2));
    }

    @Test
    public void shouldNotBreakWhenTryingToRemoveAlreadyFinishedMatch() {
        ScoreBoard scoreBoard = new ScoreBoard();

        Match match = scoreBoard.startMatch("Spain", "Germany");
        Match match2 = scoreBoard.startMatch("France", "Italy");
        Match match3 = new Match("Poland", "Belgium");

        assertTrue(scoreBoard.finishMatch(match));
        assertFalse(scoreBoard.finishMatch(match));
        assertFalse(scoreBoard.finishMatch(null));
        assertFalse(scoreBoard.finishMatch(match3));

        assertTrue(scoreBoard.getSummary().contains(match2));
        assertEquals(1, scoreBoard.getSummary().size());
    }

    @Test
    public void shouldReturnEmptyListWhenThereAreNoMatches() {
        ScoreBoard scoreBoard = new ScoreBoard();

        assertEquals(0, scoreBoard.getSummary().size());
    }

    @Test
    public void shouldReturnMatchesExactlyAsInExample() throws InterruptedException {
        ScoreBoard scoreBoard = new ScoreBoard();

        Match mexicoCanada = scoreBoard.startMatch("Mexico", "Canada");
        Thread.sleep(200);
        Match spainBrazil = scoreBoard.startMatch("Spain", "Brazil");
        Thread.sleep(200);
        Match germanyFrance = scoreBoard.startMatch("Germany", "France");
        Thread.sleep(200);
        Match uruguayItaly = scoreBoard.startMatch("Uruguay", "Italy");
        Thread.sleep(200);
        Match argentinaAustralia = scoreBoard.startMatch("Argentina", "Australia");

        mexicoCanada.updateScore(0, 5);
        spainBrazil.updateScore(10, 2);
        germanyFrance.updateScore(2, 2);
        uruguayItaly.updateScore(6, 6);
        argentinaAustralia.updateScore(3, 1);

        List<Match> summary = scoreBoard.getSummary();
        List<Match> expectedSummary = List.of(uruguayItaly, spainBrazil, mexicoCanada, argentinaAustralia, germanyFrance);

        assertEquals(5, summary.size());
        assertEquals(expectedSummary, summary);

    }

    @Test
    public void shouldNotAllowSameMatchToBeStartedTwice() {
        ScoreBoard scoreBoard = new ScoreBoard();

        scoreBoard.startMatch("Spain", "Germany");
        Exception e = assertThrows(IllegalArgumentException.class, () -> scoreBoard.startMatch("Spain", "Germany"));
        assertEquals("There is already a match between Spain and Germany", e.getMessage());
    }

}