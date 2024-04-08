package model;

import myCollection.MyList;
import onitama.Player;

public class PlayerBO {
    PlayerDAO dao = new PlayerDAO();
    MyList<Player> players = dao.getPlayers();

    public void addWin(Player player) {
        // Fing player in list
        for (Player p : players) {
            if (p.getName().equals(player.getName())) {
                p.addWin();
                dao.save();
                return;
            }
        }

        // Player not found, add new player
        player.addWin();
        players.add(player);
        dao.save();
    }

    public void addLoss(Player player) {
        // Fing player in list
        for (Player p : players) {
            if (p.getName().equals(player.getName())) {
                p.addLoss();
                dao.save();
                return;
            }
        }

        // Player not found, add new player
        player.addLoss();
        players.add(player);
        dao.save();
    }

    public void printRankingWins() {
        // Sort players by wins

        // Print ranking
        for (Player p : players) {
            System.out.println(p.getName() + " - " + p.getWins() + " wins");
        }
    }

    public void printRankingLosses() {
        // Sort players by losses
        
        // Print ranking
        for (Player p : players) {
            System.out.println(p.getName() + " - " + p.getLosses() + " losses");
        }
    }

    public void printRankingScore() {
        // Sort players by score

        // Print ranking
        for (Player p : players) {
            System.out.println(p.getName() + " - " + p.getScore() + " points");
        }
    }
}
