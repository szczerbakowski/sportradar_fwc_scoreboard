package com.sportradar.fwc.scoreboard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ScoreBoard {

    private final List<Match> matches = new ArrayList<>();

    /**
     * Starts a new match, adding it to the scoreboard.
     *
     * @param homeTeam the home team
     * @param awayTeam the away team
     * @return the newly-created match
     */
    public Match startMatch(String homeTeam, String awayTeam) {
        Match match = new Match(homeTeam, awayTeam);
        Optional<Match> existingMatch = matches.stream()
                .filter(m -> m.getHomeTeam().equals(homeTeam) || m.getAwayTeam().equals(homeTeam))
                .findAny();
        if (existingMatch.isPresent()) {
            throw new IllegalArgumentException("There is already a match between " + homeTeam + " and " + awayTeam);
        }

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
     * Return a list of matches sorted by total score in descending order, then most recently started.
     *
     * @return A list of matches.
     */
    public List<Match> getSummary() {
        return matches.stream()
                .sorted(
                    Comparator.comparing(Match::getTotalScore, Comparator.reverseOrder())
                            .thenComparing(Match::getStartTime, Comparator.reverseOrder())
                ).collect(Collectors.toList());
    }

}
