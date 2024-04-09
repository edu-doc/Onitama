package myCollection;

import java.util.List;

import model.PlayerBO;
import onitama.Player;

public class quickSort {

	public static void quickSort(MyList<Player> players) {
        if (players == null || players.size() == 0) {
            return;
        }
        sort(players, 0, players.size() - 1);
    }

    private static void sort(MyList<Player> players, int low, int high) {
        int i = low, j = high;
        int pivot = players.get(low + (high - low) / 2).getScore();

        while (i <= j) {
            while (players.get(i).getScore() < pivot) {
                i++;
            }
            while (players.get(j).getScore() > pivot) {
                j--;
            }
            if (i <= j) {
                swap(players, i, j);
                i++;
                j--;
            }
        }

        if (low < j) {
            sort(players, low, j);
        }
        if (i < high) {
            sort(players, i, high);
        }
    }

    private static void swap(MyList<Player> players, int i, int j) {
        Player temp = players.get(i);
        players.set(i, players.get(j));
        players.set(j, temp);
    }
    
    public static void main(String[] args) {
        
    	PlayerBO pbo = new PlayerBO();
    	
    	pbo.addWin("Paulo");
    	
    	pbo.addLoss("Eduardo");

        System.out.println("Lista não ordenada:");
        for (Player player : pbo.getPlayers()) {
            System.out.println(player.getName() + ": " + player.getScore());
        }

        quickSort(pbo.getPlayers());

        System.out.println("\nLista ordenada:");
        for (Player player : pbo.getPlayers()) {
            System.out.println(player.getName() + ": " + player.getScore());
        }
    }
    
}
