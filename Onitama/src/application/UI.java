package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import myCollection.MyArrayList;
import myCollection.MyLinkedListSingle;
import myCollection.MyQueueLinkedList;
import onitama.Card;
import onitama.Color;
import onitama.OnitamaCard;
import onitama.OnitamaMatch;
import onitama.OnitamaPiece;
import onitama.OnitamaPosition;

public class UI {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
        System.out.flush();
	}
	
	public static OnitamaPosition readOnitamaPosition(Scanner sc) {
		try {
			String s = sc.nextLine();
			char column = s.charAt(0);
			int row = Integer.parseInt(s.substring(1));
			return new OnitamaPosition(column, row);
		}
		catch (RuntimeException e) {
			throw new InputMismatchException("Error reading OnitamaPosition");
		}
	}

	public static MyLinkedListSingle<Card> returnPlayerCard(){
		
		if(OnitamaMatch.getCurrentPlayer() == Color.RED){
			return OnitamaCard.getListRed();
		} else if (OnitamaMatch.getCurrentPlayer() == Color.BLUE){
			return OnitamaCard.getListBlue();
		} else {
			throw new InputMismatchException("Error not cards found");
		}

	}

	public static MyQueueLinkedList<Card> returnTableCard(){
		return OnitamaCard.getQueue();
	}
	
	public static OnitamaCard readOnitamaCard(Scanner sc) {
		try {
			String s = sc.nextLine();
			return new OnitamaCard(s);
		}
		catch (RuntimeException e) {
			throw new InputMismatchException("Error Card not found");
		}
	}

	public static void exchangeCard(){
		
	}
	
	public static void printMatch(OnitamaMatch onitamaMatch, List<OnitamaPiece> captured) {
		printBoard(onitamaMatch.getPieces());
		System.out.println();
		printCapturedPieces(captured);
		System.out.println();
		System.out.println("Turn: "+ onitamaMatch.getTurn());
		System.out.println("Turn player: "+ onitamaMatch.getCurrentPlayer());
	}

	public static void printBoard(OnitamaPiece[][] pieces) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((5-i)+" ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j], false);
			}
			System.out.println();
		}
		System.out.print("  a b c d e");
	}
	
	public static void printBoard(OnitamaPiece[][] pieces, boolean[][] possibleMoves) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((5-i)+" ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j], possibleMoves[i][j]);
			}
			System.out.println();
		}
		System.out.print("  a b c d e");
	}
	
	private static void printPiece(OnitamaPiece piece, boolean background) {
		
		if (background) {
			System.out.print(ANSI_BLUE_BACKGROUND);
		}
		
		if (piece == null) {
			System.out.print("-"+ANSI_RESET);
		} else {
			if (piece.getColor() == Color.RED) {
				System.out.print(ANSI_RED + piece + ANSI_RESET);
			} else {
				System.out.print(ANSI_BLUE+ piece + ANSI_RESET);
			}
			
		}
		System.out.print(" ");
	}
	
	private static void printCapturedPieces(List<OnitamaPiece> captured) {
		List<OnitamaPiece> red = captured.stream().filter(x -> x.getColor() == Color.RED).collect(Collectors.toList());
		List<OnitamaPiece> blue = captured.stream().filter(x -> x.getColor() == Color.BLUE).collect(Collectors.toList());
		System.out.println("Captured Pieces:");
		System.out.print("Red: ");
		System.out.print(ANSI_RED);
		System.out.println(Arrays.toString(red.toArray()));
		System.out.print(ANSI_RESET);
		System.out.print("Blue: ");
		System.out.print(ANSI_BLUE);
		System.out.println(Arrays.toString(blue.toArray()));
		System.out.print(ANSI_RESET);
		
	}
	
	
	
}
 