package com.company;

public class User {

    private String name;
    private int diceroll;
    private int score;

    public User(String name, int score, int dichroll) {
        this.name = name;
        this.diceroll = dichroll;
        this.score = score;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDichroll() {
        return diceroll;
    }

    public void setDichroll(int dichroll) {
        this.diceroll = dichroll;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
