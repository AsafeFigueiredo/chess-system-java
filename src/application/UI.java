package application;

import chess.ChessPiece;

public class UI { //user interface

	public static void printBoard(ChessPiece[][] pieces) {  /*matriz da classe ChessPiece 
		com o nome de pieces*/
	
		for(int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");	 //vai imprimir os numeros ao lado	
			
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j]); //impressao de peça. pieces na posicao i e j
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	private static void printPiece(ChessPiece piece) { //impressao de peça
		if (piece == null) { //se for igual a nulo, qr dizr que nao tem peca nesse lugar
			System.out.print("-");
		}
		else {
			System.out.print(piece); //caso contrario imprime a peca
		}
		System.out.print(" "); /*no fim das contas imprime um espaco em branco para
								que as peças nao fiquem grudadas umas nas outras.*/
	}
}
