package com.company;

public class Battle {

    User server;
    User player;
    String roundInfo;
    int gameRound = 0;

    public Battle() {
    }

    public Battle(User server, User player,String roundInfo,int gameRound) {
        this.server = server;
        this.player = player;
        this.roundInfo=roundInfo;
        this.gameRound=gameRound;
    }

    public Battle(User server, User player) {
        this.server = server;
        this.player = player;
    }

    public int getGameRound() {
        return gameRound;
    }

    public void setGameRound(int gameRound) {
        this.gameRound = gameRound;
    }

    public User getServer() {
        return server;
    }

    public void setServer(User server) {
        this.server = server;
    }

    public User getPlayer() {
        return player;
    }

    public void setPlayer(User player) {
        this.player = player;
    }

    public String getRoundInfo() {
        return roundInfo;
    }

    public void setRoundInfo(String roundInfo) {
        this.roundInfo = roundInfo;
    }
}
