package com.sportradar.fwc.scoreboard;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {

    List<Match> matches = new ArrayList<>();

    public Match startMatch(String homeTeam, String awayTeam) {
        Match match = new Match(homeTeam, awayTeam);
        matches.add(match);
        return match;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void finishMatch(Match match) {
        matches.remove(match);
    }

}
