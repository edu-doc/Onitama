package application;

import onitama.OnitamaPiece;

public class UI {

	public static void printBoard(OnitamaPiece[][] pieces) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((5-i)+" ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j]);
			}
			System.out.println();
		}
		System.out.print("  a b c d e");
	}
	
	private static void printPiece(OnitamaPiece piece) {
		if (piece == null) {
			System.out.print("-");
		} else {
			System.out.print(piece);
		}
		System.out.print(" ");
	}
}
