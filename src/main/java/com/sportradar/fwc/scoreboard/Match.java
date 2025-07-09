package com.sportradar.fwc.scoreboard;

import java.util.Date;
import org.apache.commons.lang3.StringUtils;

public class Match {

    private final Date startTime;

    private final String homeTeam;
    private final String awayTeam;

    private int homeTeamScore;
    private int awayTeamScore;


    /**
     * Creates a new match with the given home and away teams.
     *
     * @param homeTeam The home team, must not be null or empty.
     * @param awayTeam The away team, must not be null or empty.
     * @throws IllegalArgumentException if either team is null or empty or team names are the same.
     */
    public Match(String homeTeam, String awayTeam) throws IllegalArgumentException {
        validateTeams(homeTeam, awayTeam);
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamScore = 0;
        this.awayTeamScore = 0;
        this.startTime = new Date();
    }

    private void validateTeams(String homeTeam, String awayTeam) {
        if (StringUtils.isBlank(homeTeam) || StringUtils.isBlank(awayTeam)) {
            throw new IllegalArgumentException("Home team and away team cannot be empty");
        }
        if (homeTeam.equals(awayTeam)) {
            throw new IllegalArgumentException("Home team and away team cannot be the same");
        }
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    /**
     * Updates the score for the home and away teams.
     *
     * @param homeTeamScore The score for the home team, must be non-negative.
     * @param awayTeamScore The score for the away team, must be non-negative.
     * @throws IllegalArgumentException if either score is negative.
     */
    public void updateScore(int homeTeamScore, int awayTeamScore) throws IllegalArgumentException {
        if (homeTeamScore < 0 || awayTeamScore < 0) {
            throw new IllegalArgumentException("Score cannot be negative");
        }
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    /**
     * Returns the total score for the match, which is the sum of the
     * home team score and the away team score.
     *
     * @return The total score.
     */
    public int getTotalScore() {
        return homeTeamScore + awayTeamScore;
    }

    public Date getStartTime() {
        return startTime;
    }
}
