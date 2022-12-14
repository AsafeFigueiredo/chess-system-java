package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch { //? nessa classe que ter?o as regras do jogo de Xadrez
	
	private Board board;
	
	public ChessMatch () { //quem tem que saber a dimensao do tabuleiro ? a classe ChessMatch, no caso, essa.
		//entao ? nessa classe que digo que ele ser? 8 por 8.
		board = new Board(8, 8); /* 1 esse board tem uma matriz de pe?as que sao do tipo Piece[][] pieces.*/
		initialSetup();  //pra ele ser testado, ele foi chamado aqui no construtor, na hora que for criada
		//a partida, ? criado um tabuleiro 8 por 8 e chamo o initialSetup.
	}
	
	public ChessPiece[][] getPieces() { /*esse m?todo vai me retornar uma matriz de pecas de xadraz
		correspondentes a essa partida.*/
		/*1 mas esse m?todo retorna um ChessPiece pois estou na camada de Xadrez. Para a minha aplicacao
		 que ser? o application.program, eu nao quero liberar a pe?as do tipo Piece, mas sim do tipo ChessPiece
		 porque estou fazendo aqui um desenvolvimento em camadas. Entao o programa ele vai poder enxergar somente
		 a pe?a de Xadrez e nao aquela pe?a interna la do tabuleiro. Ent?o, eu vou ter que liberar para o meu
		 programa uma matriz do tipo ChessPiece para que meu programa conhe?a apenas a camada de Xadrez e n?o
		 a camada de tabuleiro.*/
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		/*agora vai percorrer a matriz de pe?as do tabuleiro, que ? o board, e para cada pe?a do tabuleiro
		ser? feito um DOWNCASTING para ChessPiece.*/
		for(int i = 0; i < board.getRows(); i++) { //linhas
			for(int j = 0; j < board.getColumns(); j++) { //colunas
				mat[i][j] = (ChessPiece) board.piece(i, j); // <-- DOWNCASTING
			}
		}
		return mat;
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		/*como ser? implementado? primeiro, vou converter os dois parametros para posicoes da matriz*/
		Position source = sourcePosition.toPosition(); //origem
		Position target = targetPosition.toPosition(); //destino
		validateSourcePosition(source); //aqui valida a posicao de origem
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target);
		return (ChessPiece)capturedPiece;
	}
	
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source); // retirou a pe?a na posicao de origem
		Piece capturedPiece = board.removePiece(target); /*agora, vou declarar uma  outra
		pe?a que vai ser a pe?a capturada e essa pe?a vai receber o board.removePiece(target) ou seja
		ser? removido a possivel pe?a que esteja na posicao de destino, e ela por padrao sera a peca capturada.
		Agora que foi removido a pe?a da posi?ao de origem e removi uma possivel pe?a da posicao de destino
		eu vou poder agora colocar essa posicao que estava na origem la na posicao de destino. Entao...*/
		board.placePiece(p, target);
		return capturedPiece;
	}
	
	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) { //se nao existir uma pe?a nessa posicao
			throw new ChessException("There is no piece on source position");
		}
		if (!board.piece(position).isThereAnyPossibleMove()) { //se n?o...
			throw new ChessException("There is not possible move for the chosen piece");
		}
	}
	
	private void validateTargetPosition(Position source, Position target) { /*como fa?o da pra validar
	se a posicao de destino ela ? valida em relacao a posicao de origem. Bastar testar se essa posicao
	de destino, ela ? um movimento possivel em rela??o a pe?a que estiver na posicao de origem*/
		if (!board.piece(source).possibleMove(target)) {
			throw  new ChessException("The chosen piece can't move to target position");
		}	
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) { //aqui  ele vai receber as coordenadas do Xadrez
		board.placePiece(piece, new ChessPosition(column, row).toPosition()); /*o toPosition converte o que est;a dentro de 
ChessPosition para a posi??o de Matriz. Entao tenho uma operacao de colocar pe?a passando a posicao nas coordenadas do Xadrez*/
	}
	private void initialSetup() { /*m?todo responsavel por iniciar a partida de xadrez colocando as pe?as 
									no tabuleiro.*/
		/*board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1)); /*foi chamado o board.placePiece
		e nisso, instancair minhas pe?as. No caso a pe?a(board e a cor) e a posi??o(0, 0) dela no tabuleiro.
		//esse 0, 0 do position ? l? da camadda de board. Essa posicao ? uma posicao comum de matriz
		board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
		board.placePiece(new King(board, Color.WHITE), new Position(7, 4));*/
		
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));/*houve uma  alteracao no decorrer;
		agora no meu initialSetup, vou passar a POSI??ES DO XADREZ. Agora a instrucao esta sendo colocar
		uma nova pe?a a posicao b-6 e ser? uma torre branca.*/		
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));

		
	}
	
	

}
