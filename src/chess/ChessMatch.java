package chess;

import boardgame.Board;

public class ChessMatch { //� nessa classe que ter�o as regras do jogo de Xadrez
	
	private Board board;
	
	public ChessMatch () { //quem tem que saber a dimensao do tabuleiro � a classe ChessMatch, no caso, essa.
		//entao � nessa classe que digo que ele ser� 8 por 8.
		board = new Board(8, 8); /* 1 esse board tem uma matriz de pe�as que sao do tipo Piece[][] pieces.*/
	}
	
	public ChessPiece[][] getPieces() { /*esse m�todo vai me retornar uma matriz de pecas de xadraz
		correspondentes a essa partida.*/
		/*1 mas esse m�todo retorna um ChessPiece pois estou na camada de Xadrez. Para a minha aplicacao
		 que ser� o application.program, eu nao quero liberar a pe�as do tipo Piece, mas sim do tipo ChessPiece
		 porque estou fazendo aqui um desenvolvimento em camadas. Entao o programa ele vai poder enxergar somente
		 a pe�a de Xadrez e nao aquela pe�a interna la do tabuleiro. Ent�o, eu vou ter que liberar para o meu
		 programa uma matriz do tipo ChessPiece para que meu programa conhe�a apenas a camada de Xadrez e n�o
		 a camada de tabuleiro.*/
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		/*agora vai percorrer a matriz de pe�as do tabuleiro, que � o board, e para cada pe�a do tabuleiro
		ser� feito um downCasting para ChessPiece.*/
		for(int i = 0; i < board.getRows(); i++) {
			for(int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	
	

}
