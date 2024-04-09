package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import onitama.Color;
import onitama.OnitamaCard;
import onitama.OnitamaException;
import onitama.OnitamaMatch;
import onitama.OnitamaPiece;
import onitama.OnitamaPosition;
import model.PlayerBO;
import myCollection.quickSort;

public class Test {

	
	public static void main(String[] args) {
		menu();
	}

	public static void menu(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite para onde quer ir: ");
		System.out.println("1: Jogo");
		System.out.println("2: Ranking");
		System.out.println("3: Buscar jogador");
		System.out.println("4: Sair");
		int caso = sc.nextInt();
		sc.nextLine();
		System.out.println("");
		
		switch (caso) {
			case 1:
				jogo();
				break;
		
			case 2:
				ranking();
				break;
			
			case 4:
				System.out.println("Obrigado por jogar Onitama!");
				System.out.println("");
				break;

			default:
				System.out.println("Opção errada, digite um número relacionado a opção que queira ir");
				System.out.println("");
				menu();
				break;
		}
	}

	public static void ranking(){

		PlayerBO pbo = new PlayerBO();
		quickSort qs = new quickSort();

		qs.quickSort(pbo.getPlayers());

		System.out.println("Ranking:");
		for (int i = 0; i < 10; i++) {
			if(pbo.getPlayers().get(i) == null){
				System.out.println("Sem jogador");
			} else {
				System.out.print("Jogador: "+ pbo.getPlayers().get(i).getName() + ", Scores: ");
				System.out.println(pbo.getPlayers().get(i).getScore());
			}
			
        }

		System.out.println("");

		menu();

	}

	public static void jogo(){
		
		Scanner sc = new Scanner(System.in);

			OnitamaMatch onitamaMatch = new OnitamaMatch();
			List<OnitamaPiece> captured = new ArrayList<>();
			OnitamaCard.getListCard();

			while (!onitamaMatch.onitamaMateKill()) {
				try {
					UI.clearScreen();
					UI.printMatch(onitamaMatch, captured);
					
					System.out.println("Table card: "+UI.returnTableCard());
					System.out.println("Your cards "+UI.returnPlayerCard());
					System.out.print("Card: ");
					OnitamaCard card = UI.readOnitamaCard(sc);
					
					System.out.println();
					System.out.print("Source: ");
					OnitamaPosition source = UI.readOnitamaPosition(sc);
					
					boolean[][] possibleMoves = onitamaMatch.possibleMoves(source);
					UI.clearScreen();
					UI.printBoard(onitamaMatch.getPieces(), possibleMoves);
					
					System.out.println();
					System.out.print("Target: ");
					OnitamaPosition target = UI.readOnitamaPosition(sc);
					
					OnitamaPiece capturedPiece = onitamaMatch.perfomeOnitamaMove(source, target, card);
	
					if (capturedPiece != null) {
						captured.add(capturedPiece);
					}
					
				}
				catch(OnitamaException e) {
					System.out.println(e.getMessage());
					sc.nextLine();
				}
				catch(InputMismatchException e) {
					System.out.println(e.getMessage());
					sc.nextLine();
				}
			}
			
			PlayerBO playerBO = new PlayerBO();
			String bluePlayer = onitamaMatch.getBluePlayer();
			String redPlayer = onitamaMatch.getRedPlayer();
	
			if(onitamaMatch.getCurrentPlayer() == Color.RED) {
				System.out.println("");
				System.out.println("Blue player win");
				playerBO.addWin(bluePlayer);
				playerBO.addLoss(redPlayer);
			} else { 
				System.out.println("");
				System.out.println("Red player win");
				playerBO.addWin(redPlayer);
				playerBO.addLoss(bluePlayer);
			}	

			menu();
	}
}
