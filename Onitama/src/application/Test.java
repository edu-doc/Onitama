package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import onitama.OnitamaCard;
import onitama.OnitamaException;
import onitama.OnitamaMatch;
import onitama.OnitamaPiece;
import onitama.OnitamaPosition;

public class Test {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		OnitamaMatch onitamaMatch = new OnitamaMatch();
		
		while (true) {
			try {
				UI.printBoard(onitamaMatch.getPieces());
				
				System.out.println();
				System.out.println();
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
				
				OnitamaPiece capturedPiece = onitamaMatch.perfomeOnitamaMove(source, target);
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
		
	}

}
