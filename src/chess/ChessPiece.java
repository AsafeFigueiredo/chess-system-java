package chess;

import boardgame.Board;
import boardgame.Piece;

public class ChessPiece extends Piece { /*o comp come�a a reclamar pois falta um construtor para essa classe.
Porque essa classe � uma subclasse de Piece. Como a pe�a tem um construtor la, ele diz que tem que ter um 
construtor aqui tambem */
	
	private Color color;

	public ChessPiece(Board board, Color color) { /*foi criado o construtor recebendo o Board e o Color
	O board repassa a chamada para o construtor da superClasse. Que � o cosntrutor da classe Piece. o Color
	� normal.*/
		super(board);
		this.color = color;
	}
	

	public Color getColor() {
		return color;
	}
	
	

	
	
	
}
