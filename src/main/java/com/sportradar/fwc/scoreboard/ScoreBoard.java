package com.sportradar.fwc.scoreboard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreBoard {

    private final List<Match> matches = new ArrayList<>();

    public Match startMatch(String homeTeam, String awayTeam) {
        Match match = new Match(homeTeam, awayTeam);
        matches.add(match);
        return match;
    }

    public List<Match> getMatches() {
        return matches;
    }

    /**
     * Removes the specified match from the scoreboard.
     *
     * @param match The match to be removed.
     * @return true if the scoreboard contains the match and the match was successfully removed, false otherwise.
     */
    public boolean finishMatch(Match match) {
        return matches.remove(match);
    }

    /**
     * Return a list of matches sorted by total score in descending order, then start time ascending.
     *
     * @return A list of matches.
     */
    public List<Match> getSummary() {
        return matches.stream()
                .sorted(
                    Comparator.comparing(Match::getTotalScore).reversed()
                              .thenComparing(Match::getStartTime)
                ).collect(Collectors.toList());
    }

}
