package model;

public class testeDAO {  
    public static void main(String[] args) {
        // Read all players
        PlayerBO playerBO = new PlayerBO();

        // Print all players
        playerBO.printRankingWins();

        // Add a win to a player
        playerBO.addWin("Player2");
        playerBO.addWin("Paulo");

        // Print all players
        playerBO.printRankingWins();
    }
}
