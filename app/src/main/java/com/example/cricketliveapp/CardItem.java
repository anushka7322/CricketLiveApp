package com.example.cricketliveapp;

public class CardItem {
    private String matchTitle;
    private String matchDate;
    private String matchTime;
    private String team1Name;
    private String team1Score;
    private String team1Over;
    private String team2Name;
    private String team2Over;
    private String team2Score;
    private String matchMessage;
    private int team1Flag;
    private int team2Flag;

    public CardItem(String matchTitle,
                    String matchDate,
                    String matchTime,
                    String team1Name,
                    String team1Score,
                    String team2Name,
                    String team2Score,
                    String team1Over,
                    String team2Over,
                    String matchMessage,
                    int team1Flag,
                    int team2Flag) {
        this.matchTitle = matchTitle;
        this.matchDate = matchDate;
        this.matchTime = matchTime;
        this.team1Name = team1Name;
        this.team1Score = team1Score;
        this.team2Name = team2Name;
        this.team2Score = team2Score;
        this.team1Over = team1Over;
        this.team2Over = team2Over;
        this.matchMessage = matchMessage;
        this.team1Flag = team1Flag;
        this.team2Flag = team2Flag;
    }

    public String getMatchTitle() {
        return matchTitle;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public String getTeam1Name() {
        return team1Name;
    }

    public String getTeam1Score() {
        return team1Score;
    }

    public String getTeam2Name() {
        return team2Name;
    }

    public String getTeam2Score() {
        return team2Score;
    }

    public String getMatchMessage() {
        return matchMessage;
    }

    public int getTeam1Flag() {
        return team1Flag;
    }

    public String getTeam1Over() {
        return team1Over;
    }

    public int getTeam2Flag() {
        return team2Flag;
    }

    public String getTeam2Over() {
        return team2Over;
    }
}
