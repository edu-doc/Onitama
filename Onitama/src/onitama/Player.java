package onitama;

import java.io.Serializable;

public class Player implements Serializable{
    private String name;
    private int wins;
    private int losses;
    private int score;

    public Player(String name) {
        this.name = name;
        this.wins = 0;
        this.losses = 0;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getScore() {
        return score;
    }

    public void addWin() {
        wins++;
        score = wins - losses;
    }

    public void addLoss() {
        losses++;
        score = wins - losses;
    }

    public void reset() {
        wins = 0;
        losses = 0;
        score = 0;
    }

    // Equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        Player other = (Player) obj;
        
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        
        return true;
    }
}