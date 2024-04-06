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

public class Test {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		OnitamaMatch onitamaMatch = new OnitamaMatch();
		List<OnitamaPiece> captured = new ArrayList<>();
		
		while (!onitamaMatch.onitamaMateKill()) {
			try {
				UI.clearScreen();
				UI.printMatch(onitamaMatch, captured);
				
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
		
		if(onitamaMatch.getCurrentPlayer() == Color.RED) {
			System.out.println("");
			System.out.println("Blue player win");
		} else {
			System.out.println("");
			System.out.println("Red player win");
		}
		
		}
		
}
