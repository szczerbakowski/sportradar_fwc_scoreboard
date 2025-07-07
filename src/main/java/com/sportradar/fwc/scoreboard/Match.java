package com.sportradar.fwc.scoreboard;

import java.util.Date;

public class Match {

    private final Date startTime;

    private final String homeTeam;
    private final String awayTeam;

    private int homeTeamScore;
    private int awayTeamScore;

    public Match(String homeTeam, String awayTeam) throws IllegalArgumentException {
        if (homeTeam == null || awayTeam == null) {
            throw new IllegalArgumentException("Home team and away team cannot be null");
        }
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamScore = 0;
        this.awayTeamScore = 0;
        this.startTime = new Date();
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

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

    public int getTotalScore() {
        return homeTeamScore + awayTeamScore;
    }

    public Date getStartTime() {
        return startTime;
    }
}
