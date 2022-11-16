package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch { //� nessa classe que ter�o as regras do jogo de Xadrez
	
	private Board board;
	
	public ChessMatch () { //quem tem que saber a dimensao do tabuleiro � a classe ChessMatch, no caso, essa.
		//entao � nessa classe que digo que ele ser� 8 por 8.
		board = new Board(8, 8); /* 1 esse board tem uma matriz de pe�as que sao do tipo Piece[][] pieces.*/
		initialSetup();  //pra ele ser testado, ele foi chamado aqui no construtor, na hora que for criada
		//a partida, � criado um tabuleiro 8 por 8 e chamo o initialSetup.
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
		ser� feito um DOWNCASTING para ChessPiece.*/
		for(int i = 0; i < board.getRows(); i++) { //linhas
			for(int j = 0; j < board.getColumns(); j++) { //colunas
				mat[i][j] = (ChessPiece) board.piece(i, j); // <-- DOWNCASTING
			}
		}
		return mat;
	}
	
	private void initialSetup() { /*m�todo responsavel por iniciar a partida de xadrez colocando as pe�as 
									no tabuleiro.*/
		board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1)); /*foi chamado o board.placePiece
		e nisso, instancair minhas pe�as. No caso a pe�a(board e a cor) e a posi��o(0, 0) dela no tabuleiro.*/
		//esse 0, 0 do position � l� da camadda de board. Essa posicao � uma posicao comum de matriz
		board.placePiece(new King(board, Color.BLACK), new Position(2, 1));
		board.placePiece(new King(board, Color.WHITE), new Position(7, 4));

		
	}
	
	

}
