package chess;

import boardgame.Board;
import boardgame.Piece;

public class ChessPiece extends Piece { /*o comp começa a reclamar pois falta um construtor para essa classe.
Porque essa classe é uma subclasse de Piece. Como a peça tem um construtor la, ele diz que tem que ter um 
construtor aqui tambem */
	
	private Color color;

	public ChessPiece(Board board, Color color) { /*foi criado o construtor recebendo o Board e o Color
	O board repassa a chamada para o construtor da superClasse. Que é o cosntrutor da classe Piece. o Color
	é normal.*/
		super(board);
		this.color = color;
	}
	

	public Color getColor() {
		return color;
	}
	
	

	
	
	
}
