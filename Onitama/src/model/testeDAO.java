package model;

import myCollection.MyList;
import onitama.Player;

public class testeDAO {  
    public static void main(String[] args) {
        // Read all players
        PlayerDAO dao = new PlayerDAO();
        MyList<Player> players = dao.getPlayers();

        // Print all players
        for (Player p : players) {
            System.out.println(p.getName() + " - " + p.getWins() + " wins - " + p.getLosses() + " losses");
        } 
    }
}
