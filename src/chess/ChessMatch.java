package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch { //é nessa classe que terão as regras do jogo de Xadrez
	
	private Board board;
	
	public ChessMatch () { //quem tem que saber a dimensao do tabuleiro é a classe ChessMatch, no caso, essa.
		//entao é nessa classe que digo que ele será 8 por 8.
		board = new Board(8, 8); /* 1 esse board tem uma matriz de peças que sao do tipo Piece[][] pieces.*/
		initialSetup();  //pra ele ser testado, ele foi chamado aqui no construtor, na hora que for criada
		//a partida, é criado um tabuleiro 8 por 8 e chamo o initialSetup.
	}
	
	public ChessPiece[][] getPieces() { /*esse método vai me retornar uma matriz de pecas de xadraz
		correspondentes a essa partida.*/
		/*1 mas esse método retorna um ChessPiece pois estou na camada de Xadrez. Para a minha aplicacao
		 que será o application.program, eu nao quero liberar a peças do tipo Piece, mas sim do tipo ChessPiece
		 porque estou fazendo aqui um desenvolvimento em camadas. Entao o programa ele vai poder enxergar somente
		 a peça de Xadrez e nao aquela peça interna la do tabuleiro. Então, eu vou ter que liberar para o meu
		 programa uma matriz do tipo ChessPiece para que meu programa conheça apenas a camada de Xadrez e não
		 a camada de tabuleiro.*/
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		/*agora vai percorrer a matriz de peças do tabuleiro, que é o board, e para cada peça do tabuleiro
		será feito um DOWNCASTING para ChessPiece.*/
		for(int i = 0; i < board.getRows(); i++) { //linhas
			for(int j = 0; j < board.getColumns(); j++) { //colunas
				mat[i][j] = (ChessPiece) board.piece(i, j); // <-- DOWNCASTING
			}
		}
		return mat;
	}
	
	private void initialSetup() { /*método responsavel por iniciar a partida de xadrez colocando as peças 
									no tabuleiro.*/
		board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1)); /*foi chamado o board.placePiece
		e nisso, instancair minhas peças. No caso a peça(board e a cor) e a posição(0, 0) dela no tabuleiro.*/
		//esse 0, 0 do position é lá da camadda de board. Essa posicao é uma posicao comum de matriz
		board.placePiece(new King(board, Color.BLACK), new Position(2, 1));
		board.placePiece(new King(board, Color.WHITE), new Position(7, 4));

		
	}
	
	

}
