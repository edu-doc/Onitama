package model;
import myCollection.MyList;
import myCollection.MyArrayList;
import onitama.Player;
import java.io.*;

public class PlayerDAO {
    // Persistence with binary file
    private MyList<Player> players;

    @SuppressWarnings("unchecked")
    public PlayerDAO() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ranking.dat"));
            players = (MyList<Player>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            players = new MyArrayList<>();
        }
    }

    public void add(Player player) {
        players.add(player);
    }

    public void remove(Player player) {
        players.remove(player);
    }

    public MyList<Player> getPlayers() {
        if (players == null) {
            players = new MyArrayList<>();
        }
        return players;
    }

    public void save() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ranking.dat"));
            oos.writeObject(players);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
