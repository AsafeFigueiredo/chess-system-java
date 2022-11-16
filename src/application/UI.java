package application;

import chess.ChessPiece;
import chess.Color;

public class UI { // UI = User Interface
	
	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

		public static final String ANSI_RESET = "\u001B[0m";   //codigos especiais das cores pra imprimir no console
		public static final String ANSI_BLACK = "\u001B[30m";
		public static final String ANSI_RED = "\u001B[31m";
		public static final String ANSI_GREEN = "\u001B[32m";
		public static final String ANSI_YELLOW = "\u001B[33m";
		public static final String ANSI_BLUE = "\u001B[34m";
		public static final String ANSI_PURPLE = "\u001B[35m";
		public static final String ANSI_CYAN = "\u001B[36m";
		public static final String ANSI_WHITE = "\u001B[37m";

		public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";  //background
		public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
		public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
		public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
		public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
		public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
		public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
		public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";


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
		
		/*if (piece == null) { //se for igual a nulo, qr dizr que nao tem peca nesse lugar
			System.out.print("-");
		}
		else {
			System.out.print(piece); //caso contrario imprime a peca
		}
		System.out.print(" "); /*no fim das contas imprime um espaco em branco para
								que as peças nao fiquem grudadas umas nas outras.*/		
	    	
		if (piece == null) {
	            System.out.print("-"); 		//no decorrer do rolê houveram algumas mudanças e foi adicionado OUTRO } else {
	        }
	        else {				
	            if (piece.getColor() == Color.WHITE) { /*se a cor da peça for a cor branca, a gente vai impirmir a cor com o  
	            codigo do branco*/
	                System.out.print(ANSI_WHITE + piece + ANSI_RESET); //ansi reset ; reseta a cor
	            }
	            else {  //se nao, a gnt vai usar a cor amarela
	                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);  
	            }
	        }
	        System.out.print(" ");
		}
	}


