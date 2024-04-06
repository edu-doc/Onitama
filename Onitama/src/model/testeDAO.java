package model;

import myCollection.MyList;
import onitama.Player;

public class testeDAO {  
    public static void main(String[] args) {
        PlayerDAO dao = new PlayerDAO();
        MyList<Player> players = dao.getPlayers();

        Player p1 = new Player("Alice");
        Player p2 = new Player("Bob");
        Player p3 = new Player("Charlie");

        players.add(p1);
        players.add(p2);
        players.add(p3);

        dao.save();

        // Read from file
        dao = new PlayerDAO();
        players = dao.getPlayers();

        for (Player p : players) {
            System.out.println(p.getName());
        }

        System.out.println("----");

        // Remove a player
        players.remove(p2);
        dao.save();

        // Read from file
        dao = new PlayerDAO();
        players = dao.getPlayers();

        for (Player p : players) {
            System.out.println(p.getName());
        }

        // Reset
        players.clear();
        dao.save();
    }
}
