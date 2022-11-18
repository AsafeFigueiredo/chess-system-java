package chess;

import boardgame.Board;
import boardgame.Piece;
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
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		/*como será implementado? primeiro, vou converter os dois parametros para posicoes da matriz*/
		Position source = sourcePosition.toPosition(); //origem
		Position target = targetPosition.toPosition(); //destino
		validateSourcePosition(source); //aqui valida a posicao de origem
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source, target);
		return (ChessPiece)capturedPiece;
	}
	
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source); // retirou a peça na posicao de origem
		Piece capturedPiece = board.removePiece(target); /*agora, vou declarar uma  outra
		peça que vai ser a peça capturada e essa peça vai receber o board.removePiece(target) ou seja
		será removido a possivel peça que esteja na posicao de destino, e ela por padrao sera a peca capturada.
		Agora que foi removido a peça da posiçao de origem e removi uma possivel peça da posicao de destino
		eu vou poder agora colocar essa posicao que estava na origem la na posicao de destino. Entao...*/
		board.placePiece(p, target);
		return capturedPiece;
	}
	
	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) { //se nao existir uma peça nessa posicao
			throw new ChessException("There is no piece on source position");
		}
		if (!board.piece(position).isThereAnyPossibleMove()) { //se não...
			throw new ChessException("There is not possible move for the chosen piece");
		}
	}
	
	private void validateTargetPosition(Position source, Position target) { /*como faço da pra validar
	se a posicao de destino ela é valida em relacao a posicao de origem. Bastar testar se essa posicao
	de destino, ela é um movimento possivel em relação a peça que estiver na posicao de origem*/
		if (!board.piece(source).possibleMove(target)) {
			throw  new ChessException("The chosen piece can't move to target position");
		}	
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) { //aqui  ele vai receber as coordenadas do Xadrez
		board.placePiece(piece, new ChessPosition(column, row).toPosition()); /*o toPosition converte o que est;a dentro de 
ChessPosition para a posição de Matriz. Entao tenho uma operacao de colocar peça passando a posicao nas coordenadas do Xadrez*/
	}
	private void initialSetup() { /*método responsavel por iniciar a partida de xadrez colocando as peças 
									no tabuleiro.*/
		/*board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1)); /*foi chamado o board.placePiece
		e nisso, instancair minhas peças. No caso a peça(board e a cor) e a posição(0, 0) dela no tabuleiro.
		//esse 0, 0 do position é lá da camadda de board. Essa posicao é uma posicao comum de matriz
		board.placePiece(new King(board, Color.BLACK), new Position(0, 4));
		board.placePiece(new King(board, Color.WHITE), new Position(7, 4));*/
		
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));/*houve uma  alteracao no decorrer;
		agora no meu initialSetup, vou passar a POSIÇÕES DO XADREZ. Agora a instrucao esta sendo colocar
		uma nova peça a posicao b-6 e será uma torre branca.*/		
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
